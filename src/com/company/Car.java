package com.company;

public class Car {
    public final String producer;
    public final String model;
    public Double fuelConsumption;
    public Integer numberOfPistons;
    public Double carValue;

    //Constructor with parameters producer and model
    public Car(String producer, String model) {
        this.producer = producer;
        this.model = model;
    }
}
