package com.company.devices;

import com.company.creatures.Human;

import java.util.Objects;

public abstract class Car extends Device {

    public Double fuelConsumption;
    public Double carValue;

    public Car(String producer, String model, Integer yearOfProduction, Double fuelConsumption, Double carValue) {
        super(producer, model, yearOfProduction);
        this.fuelConsumption = fuelConsumption;
        this.carValue = carValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(fuelConsumption, car.fuelConsumption) && Objects.equals(carValue, car.carValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelConsumption, carValue);
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelConsumption=" + fuelConsumption +
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

    //Declaration of abstract method refuel
    public abstract void refuel();


}
