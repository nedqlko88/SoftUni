package car.dealer.controllers;


import car.dealer.dtos.CustomerDto;
import car.dealer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public ModelAndView index() {


        return super.view("index", customers);
    }

//    @GetMapping("/all/descending")
//    public ModelAndView getAllDescendingOrder() {
//        CustomersOrderDto customersOrderDto = new CustomersOrderDto();
//        List<CustomerDto> customers = this.customerService.getAllCustomersOrderByBirthDateDescendingOrder();
//        customersOrderDto.setCustomerDtos(customers);
//        customersOrderDto.setOrder("descending");
//        return super.view("views/customers/all", customersOrderDto);
//    }
//
//    @GetMapping("/{id}")
//    public ModelAndView getSalesByCustomer(@PathVariable(name = "id") long id) {
//        SalesByCustomerDto salesByCustomerId = this.customerService.findSalesByCustomerId(id);
//        return super.view("views/customers/sales", salesByCustomerId);
//    }
//
//    @GetMapping("/add")
//    public ModelAndView add() {
//        return super.view("views/customers/add");
//    }
//
//    @PostMapping("/add")
//    public ModelAndView addConfirm(@ModelAttribute CreateCustomerDto createCustomerDto) {
//        this.customerService.createCustomer(createCustomerDto);
//        return super.redirect("/");
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView edit(@PathVariable("id") Long id) {
//        EditCustomerDto editCustomerDto = customerService.getCustomerById(id);
//        return super.view("views/customers/edit", editCustomerDto);
//    }
//
//    @PostMapping("/edit/{id}")
//    public ModelAndView editConfirm(@ModelAttribute EditCustomerDto editCustomerDto, @PathVariable("id") Long id) {
//        this.customerService.editCustomer(editCustomerDto, id);
//        return super.redirect("/");
//    }
}