package car.dealer.services;


import car.dealer.dtos.CarDto;

import java.util.List;

public interface CarService {

    List<CarDto> getAllCarsByMakeOrderedByModelAndKm(String make);
}
