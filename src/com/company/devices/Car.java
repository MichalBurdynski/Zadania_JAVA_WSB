package com.company.devices;

import com.company.creatures.Human;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Car extends Device {

    public Double fuelConsumption;
    public final ArrayList<Transaction> ownerList;

    public Car(String producer, String model, Integer yearOfProduction, Double value, Double fuelConsumption) {
        super(producer, model, yearOfProduction, value);
        this.fuelConsumption = fuelConsumption;
        this.ownerList = new ArrayList<>();
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
                ", ownerList=" + ownerList +
                "} " + super.toString();
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
        //Checking if seller has an item to sell and is the owner
        try {
            for (int i = 0; i < seller.garageCapacity; i++) {
                Car transactionItem = seller.getCar(i);
                int lastIndexOfTransaction;
                if (transactionItem != null) {
                    if (transactionItem.ownerList.size() == 0) {
                        throw new Exception("Auto nie ma własciciela.");
                    } else {
                        lastIndexOfTransaction = transactionItem.ownerList.size() - 1;
                    }
                    Human carLastOwner = transactionItem.ownerList.get(lastIndexOfTransaction).getDeviceOwner();

                    if (this.equals(transactionItem) && carLastOwner == seller) {
                        isOwner = true;
                        carPositionInGarage = i;
                        break;
                    }
                }
            }

            if (!isOwner) {
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
            Transaction transaction = new Transaction(seller, buyer, price);
            this.ownerList.add(transaction);
            System.out.println("Samochód sprzedany.");
        }
    }

    //Declaration of abstract method refuel
    public abstract void refuel();

    //Method checking whether a man owned the car
    public boolean wasCarOwner(Human human)
    {
        boolean wasCarOwner = false;
        for (Transaction checkedTransaction : this.ownerList) {
            if (checkedTransaction.getDeviceOwner() == human || checkedTransaction.getDevicePreviousOwner() == human) {
                wasCarOwner = true;
                break;
            }
        }

        return wasCarOwner;
    }

    //Method checking whether humanA sold a car to humanB
    public boolean wasCarSold(Human humanA, Human humanB)
    {
        boolean wasCarSold = false;
        for (Transaction checkedTransaction : this.ownerList) {
            if (checkedTransaction.getDeviceOwner() == humanB && checkedTransaction.getDevicePreviousOwner() == humanA) {
                wasCarSold = true;
                break;
            }
        }
        return wasCarSold;
    }

    //Method returning number of car sales transactions
    public Integer getNumberOfTransactions()
    {
        return this.ownerList.size();
    }
}
