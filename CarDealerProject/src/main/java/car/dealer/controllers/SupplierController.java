package car.dealer.controllers;

import car.dealer.dtos.SupplierDto;
import car.dealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{type}")
    public ModelAndView getAllSuppliersByImport(@PathVariable String type, ModelAndView modelAndView) {
        Set<SupplierDto> suppliers = new HashSet<>();

        if ("local".equals(type)) {
            suppliers = this.supplierService.getAllSuppliersByImporter(false);
        } else if ("importers".equals(type)) {
            suppliers = this.supplierService.getAllSuppliersByImporter(true);
        } else {
            suppliers = this.supplierService.getAllSuppliers();
        }

        modelAndView.setViewName("suppliers/all");
        modelAndView.addObject("suppliers", suppliers);
        modelAndView.addObject("type", type);

        return modelAndView;

    }
}
