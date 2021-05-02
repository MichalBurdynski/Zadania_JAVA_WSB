package com.company.devices;

import com.company.Human;
import com.company.Soldable;

public abstract class Car extends Device implements Soldable {
    public Double fuelConsumption;
    public Integer numberOfPistons;
    public Double carValue;
    private Integer chassisNumber;

    //Construtor with parameters producer and model
    public Car(String producer, String model)
    {
        this.producer = producer;
        this.model = model;
    }

    //Constructor with parameters producer, model, chassisnumber
    public Car(String producer, String model, Integer chassisNumber)
    {
        this.producer = producer;
        this.model = model;
        this.chassisNumber = chassisNumber;
    }

    //Overridden equals method
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }
        return (producer.equals(((Car) o).producer) && model.equals(((Car) o).model) && fuelConsumption == ((Car) o).fuelConsumption) && numberOfPistons == (((Car) o).numberOfPistons) && carValue == (((Car) o).carValue);
    }


    //toString method containing fields from abstract class Car
    public String toString()
    {
        return "marka auta: " + producer + " model: " + model + " " + " zużycie paliwa: " + fuelConsumption + " liczba cylindrów: " + numberOfPistons + " wartość auta: " + carValue;
    }

    //Overridden method hashCode. It return chassisnumber as unique identifier
    @Override
    public int hashCode()
    {
        return chassisNumber;
    }

    //implementation of abstract method turnOn
    public void turnOn()
    {
        System.out.println("Auto uruchomione.");
    }

    //Implementation of interface Soldable
    public void sell(Human seller, Human buyer, Double price)
    {
        if(seller.ownedCar() != null && buyer.cash() > price) {
            seller.incomeCash(price);
            buyer.incomeCash(-price);
            buyer.buyDevice(seller.ownedCar());
            seller.buyDevice(null);
            System.out.println("Urządzenie sprzedane.");

        }
        else if (seller.ownedCar() == null)
        {
            System.out.println("Sprzedający nie ma urządzenia.");
        }
        else
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
    }

    public abstract void refuel();
}
