package car.dealer.services;

import car.dealer.dtos.SupplierDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Override
    public List<SupplierDto> getAllSuppliersImporters() {
        return null;
    }

    @Override
    public List<SupplierDto> getAllSuppliersNotImporters() {
        return null;
    }
}
