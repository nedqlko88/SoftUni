package car.dealer.services;

import car.dealer.dtos.customers.CustomerDto;
import car.dealer.dtos.customers.CustomerSalesDto;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomersOrderByBirthDateAscendingOrder();

    List<CustomerDto> getAllCustomersOrderByBirthDateDescendingOrder();

    CustomerSalesDto getCustomerById(Long id);
}
