package com.company.devices;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return producer.equals(car.producer) && model.equals(car.model) && Objects.equals(fuelConsumption, car.fuelConsumption) && Objects.equals(numberOfPistons, car.numberOfPistons) && Objects.equals(carValue, car.carValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, fuelConsumption, numberOfPistons, carValue);
    }

    @Override
    public String toString() {
        return "Car{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", fuelConsumption=" + fuelConsumption +
                ", numberOfPistons=" + numberOfPistons +
                ", carValue=" + carValue +
                '}';
    }
}
