package com.audsat.insurance.service;

import com.audsat.insurance.DTO.CarDTO;
import com.audsat.insurance.model.Car;
import com.audsat.insurance.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car handleCarInsertion(CarDTO car) {
        boolean isAlreadyRegistered = carRepository.existsById(car.getCarId());
        if (!isAlreadyRegistered) {
            Car carDB = new Car(car.getCarId(), car.getModel(), car.getManufacturer(),
                    car.getYear(), car.getFipeValue());
            return carRepository.save(carDB);
        }
        return carRepository.findOneById(car.getCarId()).orElseThrow(IllegalArgumentException::new);
    }
}
