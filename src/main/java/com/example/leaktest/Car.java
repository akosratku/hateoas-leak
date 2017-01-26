package com.example.leaktest;

import org.springframework.hateoas.ResourceSupport;

public class Car extends ResourceSupport
{

    private final String carId;

    public Car(final String carId)
    {
        super();
        this.carId = carId;
    }

    public String getCarId()
    {
        return carId;
    }

}
