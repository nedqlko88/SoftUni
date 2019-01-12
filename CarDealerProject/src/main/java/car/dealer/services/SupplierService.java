package car.dealer.services;

import car.dealer.dtos.SupplierDto;

import java.util.List;

public interface SupplierService {
    List<SupplierDto> getAllSuppliersImporters();

    List<SupplierDto> getAllSuppliersNotImporters();

}
