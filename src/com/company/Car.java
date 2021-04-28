package com.company;

public class Car {
    public final String producer;
    public final String model;
    public Double fuelConsumption;
    public Integer numberOfPistons;
    public Double carValue;

    Car(String producer, String model)
    {
        this.producer = producer;
        this.model = model;
    }
}
