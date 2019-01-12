package car.dealer.controllers;

import car.dealer.dtos.CarDto;
import car.dealer.services.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{make}")
    public ModelAndView getAllCarsByMake(ModelAndView modelAndView, @PathVariable String make) {
        modelAndView.setViewName("cars/all");

        List<CarDto> cars = this.carService.getAllCarsByMakeOrderedByModelAndKm(make);

        modelAndView.addObject("make", make);
        modelAndView.addObject("cars", cars);

        return modelAndView;
    }
}
