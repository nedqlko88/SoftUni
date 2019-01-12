package car.dealer.services;

import car.dealer.dtos.CarDto;
import car.dealer.entities.Car;
import car.dealer.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CarDto> getAllCarsByMakeOrderedByModelAndKm(String make) {
        List<Car> cars = this.carRepository.getAllByMakeOrderByModelAscAndByKmDesc(make);
        List<CarDto> carDtos = new ArrayList<>();

        cars.forEach(car -> {
                    CarDto mappedCar = this.modelMapper.map(car, CarDto.class);
                    carDtos.add(mappedCar);
                } );

        return carDtos;
    }
}
