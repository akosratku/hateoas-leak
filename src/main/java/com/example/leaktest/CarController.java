package com.example.leaktest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController
{

    @RequestMapping("/cars")
    public List<Car> getAll()
    {
        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i <= 100; i++)
        {
            final Car car = new Car(UUID.randomUUID().toString());
            car.add(linkTo(methodOn(this.getClass()).getCar(car.getCarId())).withSelfRel());
            cars.add(car);
        }
        return cars;
    }

    @RequestMapping("/cars/{id}")
    public Car getCar(@PathVariable("id") final String id)
    {
        return new Car(id);
    }

}
