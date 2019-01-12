package car.dealer.controllers;


import car.dealer.dtos.customers.CustomerDto;
import car.dealer.dtos.customers.CustomerSalesDto;
import car.dealer.services.CustomerService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all/ascending")
    public ModelAndView getCustomersAscending(ModelAndView modelAndView) {
        modelAndView.setViewName("customers/all");
        List<CustomerDto> customersAsc = this.customerService.getAllCustomersOrderByBirthDateAscendingOrder();
        modelAndView.addObject("customers", customersAsc);
        modelAndView.addObject("order", "ascending");

        return modelAndView;
    }

    @GetMapping("/all/descending")
    public ModelAndView getCustomersDescending(ModelAndView modelAndView) {
        modelAndView.setViewName("customers/all");
        List<CustomerDto> customersDesc = this.customerService.getAllCustomersOrderByBirthDateDescendingOrder();
        modelAndView.addObject("customers", customersDesc);
        modelAndView.addObject("order", "descending");

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getSalesByCustomer(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
        modelAndView.setViewName("customers/customer-sales");
        CustomerSalesDto customer = this.customerService.getCustomerById(id);
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }

}