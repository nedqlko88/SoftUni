package car.dealer.services;

import car.dealer.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomersOrderByBirthDateAscendingOrder();

    List<CustomerDto> getAllCustomersOrderByBirthDateDescendingOrder();

    List<CustomerDto> getCustomersByOrderByBirthDateAscYoungDriverAsc();

    CustomerDto getCustomerById(Long id);
}
