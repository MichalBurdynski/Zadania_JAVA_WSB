package com.company.devices;

import com.company.Human;

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

    //Implementation of the sell method of interface Saleable
    public void sell(Human seller, Human buyer, Double price)
    {
        if (seller.getCar() == null)
        {
        System.out.println("Sprzedający nie ma samochodu, który próbuje sprzedać.");
        }
        else if (buyer.cash < price)
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
        else if (buyer.cash >= price && seller.getCar().equals(this)) {
            seller.cash += price;
            buyer.cash -= price;
            buyer.setCar(this);
            seller.setCar(null);
            System.out.println("Samochód sprzedany.");
        }

    }
}
