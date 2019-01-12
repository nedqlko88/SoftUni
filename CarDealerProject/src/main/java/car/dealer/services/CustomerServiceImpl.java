package car.dealer.services;

import car.dealer.dtos.customers.CustomerDto;
import car.dealer.dtos.customers.CustomerSalesDto;
import car.dealer.entities.Car;
import car.dealer.entities.Customer;
import car.dealer.entities.Part;
import car.dealer.entities.Sale;
import car.dealer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public CustomerSalesDto getCustomerById(Long id) {
        Customer customer = this.customerRepository.getOne(id);
        CustomerSalesDto customerSalesDto = new CustomerSalesDto();

        Set<Sale> sales = customer.getSales();

        int carsCount = sales.size();

        Double sum = 0.0;

        for (Sale sale : sales) {
            Double discount = sale.getDiscount();
            Car carId = sale.getCarId();
            Set<Part> parts = carId.getParts();

            for (Part part : parts) {
                Double price = part.getPrice();
                sum += price / discount;
            }
        }

        customerSalesDto.setName(customer.getName());
        customerSalesDto.setCarsCount(carsCount);
        customerSalesDto.setSpentMoney(sum);

        return customerSalesDto;
    }

}
