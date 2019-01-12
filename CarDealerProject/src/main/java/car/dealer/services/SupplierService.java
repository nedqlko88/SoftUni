package car.dealer.services;

import car.dealer.dtos.SupplierDto;

import java.util.List;
import java.util.Set;

public interface SupplierService {
    Set<SupplierDto> getAllSuppliersByImporter(boolean isImporter);

    Set<SupplierDto> getAllSuppliers();


}
