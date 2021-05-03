package com.company.devices;

import com.company.Human;
import com.company.Soldable;

public abstract class Car extends Device implements Soldable {
    public Double fuelConsumption;
    private Integer chassisNumber;

    //Constructor with parameters producer and model
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
        return (producer.equals(((Car) o).producer) && model.equals(((Car) o).model) && fuelConsumption == ((Car) o).fuelConsumption) && value == ((Car) o).value && yearOfProduction == ((Car) o).yearOfProduction;
    }


    //toString method containing fields from abstract class Car
    public String toString()
    {
        return super.toString() + "\nZużycie środka napędowego: " + fuelConsumption;
    }

    //Overridden method hashCode. It return chassisNumber as unique identifier
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
    public void sell(Human seller, Human buyer, Double price) throws Exception {
        {
            //Checking whether seller has a car in garage
                boolean isOwner = false;
                Integer carPositionInGarage = null;
                if (seller.ownedCars().length > 0) {
                    for (int i = 0; i < seller.ownedCars().length; i++) {
                        if (seller.ownedCars()[i] == this) {
                            isOwner = true;
                            carPositionInGarage = i;
                            break;
                        }
                    }
                }
                if (!isOwner) throw new Exception("Sprzedający nie ma samochodu.");


            //Checking whether buyer has a free space in garage

                int freeGarageSpaces = buyer.ownedCars().length;
                if (buyer.ownedCars().length > 0) {
                    for (int i = 0; i < buyer.ownedCars().length; i++) {
                        if (buyer.ownedCars()[i] != null) {
                            freeGarageSpaces--;
                        }
                    }
                }
                if (freeGarageSpaces == 0) throw new Exception("Kupujący nie ma miejsca w garażu.");


            //Checking whether buyer has appropriate amount of cashAvailable

                if (buyer.cashAvailable() < price) throw new Exception("Kupujący nie ma wystarczającej ilości pieniędzy");

            Integer newCarPositionInGarage = null;
            if (buyer.ownedCars().length > 0) {
                for (int i = 0; i < buyer.ownedCars().length; i++) {
                    if (buyer.ownedCars()[i] == null) {
                        newCarPositionInGarage = i;
                        break;
                    }
                }
            }

                seller.incomeCash(price);
                buyer.incomeCash(-price);
                Car soldCar = seller.getCar(carPositionInGarage);
                buyer.setCar(soldCar, newCarPositionInGarage);
                seller.setCar(null, carPositionInGarage);
                System.out.println("Samochód sprzedany.");
            }
        }

    public abstract void refuel();
}
