package com.commun.service;

import com.commun.model.Car;
import com.commun.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car update(Long id, Car car) {
        Car carFound = carRepository.findById(id).orElse(null);
        if (carFound != null) {
            carFound.setModel(car.getModel());
            carFound.setBrand(car.getBrand());
            carFound.setYear(car.getYear());
            carFound.setColor(car.getColor());
            carFound.setPrice(car.getPrice());
            return carRepository.save(carFound);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Car carFound = carRepository.findById(id).orElse(null);
        if (carFound != null) {
            carRepository.deleteById(id);
        }
    }
}
