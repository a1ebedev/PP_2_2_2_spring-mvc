package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CarServiceImp implements CarService {
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Toyota Camry", 2022, 25000.0));
        cars.add(new Car("Honda Accord", 2021, 23000.0));
        cars.add(new Car("Ford Mustang", 2023, 35000.0));
        cars.add(new Car("Chevrolet Malibu", 2020, 27000.0));
        cars.add(new Car("Nissan Altima", 2022, 24000.0));
    }

    @Override
    public List<Car> listCars(int count) {
        if (count == 0 || count > cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }

}
