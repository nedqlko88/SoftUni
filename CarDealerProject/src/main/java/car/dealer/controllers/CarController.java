package car.dealer.controllers;

import car.dealer.dtos.CarDto;
import car.dealer.dtos.PartDto;
import car.dealer.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @Autowired
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

    @GetMapping("/{id}/parts")
    public ModelAndView getCarsParts(ModelAndView modelAndView, @PathVariable String id) {
        Long parsedId = Long.valueOf(id);
        CarDto car = this.carService.getCarById(parsedId);
        Set<PartDto> parts = car.getParts();

        modelAndView.setViewName("cars/car-with-parts");
        modelAndView.addObject("carById", car);
        modelAndView.addObject("parts", parts);

        return modelAndView;

    }
}
