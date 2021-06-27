package com.company.devices;

import com.company.creatures.Human;

import java.util.Objects;

public abstract class Car extends Device {

    public Double fuelConsumption;

    public Car(String producer, String model, Integer yearOfProduction, Double value, Double fuelConsumption) {
        super(producer, model, yearOfProduction, value);
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(fuelConsumption, car.fuelConsumption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelConsumption);
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuelConsumption=" + fuelConsumption +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", value=" + value +
                '}';
    }

    @Override
    public void turnOn() {
        System.out.println("Samochód uruchomiony.");
    }

    //Implementation of the sell method of interface Saleable
    public void sell(Human seller, Human buyer, Double price) {

        int carPositionInGarage = 0;
        boolean isOwner = false;
        int freeGarageSpaces = 0;
        //Checking if seller has an item to sell
        try
        {

        for (int i = 0; i < seller.garageCapacity ; i++)
        {
            if (this.equals(seller.getCar(i)))
            {
                isOwner = true;
                carPositionInGarage = i;
                break;
            }
        }
           if (!isOwner)
           {
               throw new Exception();
           }
        }
        catch (Exception e)
        {
            System.out.println("Sprzedający nie ma samochodu, który próbuje sprzedać.");
        }

        //Checking if buyer has enough cash
        try {
            if (buyer.cash < price)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }

        //Checking whether buyer has a free garage space
        try {
            freeGarageSpaces = buyer.garageCapacity;
            if (buyer.garageCapacity > 0) {
                for (int i = 0; i < buyer.garageCapacity; i++) {
                    if (buyer.getCar(i) != null) {
                        freeGarageSpaces--;
                    }
                }
            }
            if (freeGarageSpaces == 0)
            {
                throw new Exception();
            }
        }
        catch (Exception e) {
            System.out.println("Kupujący nie ma miejsca w garażu.");
        }

        //If all conditions are met - transaction is executed.

        //Looking for the first place in buyer garage.
        int newCarPositionInGarage = 0;
        if (buyer.garageCapacity> 0) {
            for (int i = 0; i < buyer.garageCapacity; i++) {
                if (buyer.getCar(i) == null) {
                    newCarPositionInGarage = i;
                    break;
                }
            }
        }

        if (isOwner && (buyer.cash > price) && freeGarageSpaces !=0) {
            seller.cash += price;
            buyer.cash -= price;
            buyer.setCar(this, newCarPositionInGarage);
            seller.setCar(null, carPositionInGarage);
            System.out.println("Samochód sprzedany.");
        }
    }

    //Declaration of abstract method refuel
    public abstract void refuel();


}
