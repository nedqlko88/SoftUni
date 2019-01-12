package car.dealer.services;

import car.dealer.dtos.SupplierDto;
import car.dealer.entities.Supplier;
import car.dealer.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;


    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Set<SupplierDto> getAllSuppliersByImporter(boolean isImporter) {
        List<Supplier> suppliers = this.supplierRepository.getSuppliersByImporter(isImporter);

        return this.mapSuppliers(suppliers);
    }

    @Override
    public Set<SupplierDto> getAllSuppliers() {
        List<Supplier> allSuppliers = this.supplierRepository.findAll();

        return this.mapSuppliers(allSuppliers);
    }

    private Set<SupplierDto> mapSuppliers(List<Supplier> suppliers) {
        Set<SupplierDto> supplierDtos = new HashSet<>();

        for (Supplier supplier : suppliers) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(supplier.getId());
            supplierDto.setName(supplier.getName());
            supplierDto.setNumberOfParts(supplier.getParts().size());
            supplierDto.setImporter(supplier.isImporter());
            supplierDtos.add(supplierDto);
        }
        return supplierDtos;
    }

}
