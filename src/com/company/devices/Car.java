package com.company.devices;

import java.util.Objects;

public class Car extends Device {

    public Double fuelConsumption;
    public Integer numberOfPistons;
    public Double carValue;

    public Car(String producer, String model, Integer yearOfProduction, Double fuelConsumption, Integer numberOfPistons, Double carValue) {
        super(producer, model, yearOfProduction);
        this.fuelConsumption = fuelConsumption;
        this.numberOfPistons = numberOfPistons;
        this.carValue = carValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(fuelConsumption, car.fuelConsumption) && Objects.equals(numberOfPistons, car.numberOfPistons) && Objects.equals(carValue, car.carValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelConsumption, numberOfPistons, carValue);
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelConsumption=" + fuelConsumption +
                ", numberOfPistons=" + numberOfPistons +
                ", carValue=" + carValue +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }

    @Override
    public void turnOn() {
        System.out.println("Samochód uruchomiony.");
    }
}
