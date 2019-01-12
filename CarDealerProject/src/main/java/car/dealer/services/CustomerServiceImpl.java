package car.dealer.services;

import car.dealer.dtos.CustomerDto;
import car.dealer.entities.Customer;
import car.dealer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDto> getAllCustomersOrderByBirthDateAscendingOrder() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        this.customerRepository.getCustomersByOrderByBirthDateAsc()
                .forEach(customer ->
                        customerDtos.add(this.modelMapper.map(customer, CustomerDto.class)));
        return customerDtos;
    }

    @Override
    public List<CustomerDto> getAllCustomersOrderByBirthDateDescendingOrder() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        this.customerRepository.getCustomersByOrderByBirthDateDesc()
                .forEach(customer ->
                        customerDtos.add(this.modelMapper.map(customer, CustomerDto.class)));
        return customerDtos;
    }

}
