package com.company.devices;

import com.company.Human;
import com.company.Soldable;

import java.util.ArrayList;

public abstract class Car extends Device implements Soldable {
    public Double fuelConsumption;
    private Integer chassisNumber;

    private final ArrayList<Transaction> ownerList;

    //Constructor with parameters producer and model
    public Car(String producer, String model)
    {
        this.producer = producer;
        this.model = model;
        this.ownerList = new ArrayList<>();
    }

    //Constructor with parameters producer, model and chassisnumber
    public Car(String producer, String model, Integer chassisNumber)
    {
        this.producer = producer;
        this.model = model;
        this.chassisNumber = chassisNumber;
        this.ownerList = new ArrayList<>();
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
        return (producer.equals(((Car) o).producer) && model.equals(((Car) o).model) && fuelConsumption == ((Car) o).fuelConsumption) && value == ((Car) o).value && yearOfProduction == ((Car) o).yearOfProduction && ownerList == ((Car) o).ownerList;
    }


    //toString method containing fields from abstract class Device and inherited class Car
    @Override
    public String toString()
    {
        String string = super.toString() + "\nZużycie środka napędowego: " + fuelConsumption;
        if (!ownerList.isEmpty()) {
             string += "\nLista transakcji sprzedaży auta:\n"+ownerList;
        }
        else
        {
            string += "\nNie odnotowano transakcji.";
        }

        return  string;
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
            //Checking whether seller has a car in garage and is the owner
                boolean isOwner = false;
                Integer carPositionInGarage = null;
                    for (int i = 0; i < seller.ownedCars().length; i++) {
                        Car transactionItem = seller.ownedCars()[i];
                        int lastIndexOfTransaction;
                        if (transactionItem != null) {
                            if (transactionItem.ownerList.size() == 0) {
                                throw new Exception("Auto nie ma własciciela.");
                            } else {
                                lastIndexOfTransaction = transactionItem.ownerList.size() - 1;
                            }
                            Human carLastOwner = transactionItem.ownerList.get(lastIndexOfTransaction).deviceOwner();
                            if (transactionItem == this && carLastOwner == seller) {
                                isOwner = true;
                                carPositionInGarage = i;
                                break;
                            }
                        }
                    }

                if (!isOwner) throw new Exception("Sprzedający nie ma samochodu.");


            //Checking whether buyer has a free garage space

                int freeGarageSpaces = buyer.ownedCars().length;
                if (buyer.ownedCars().length > 0) {
                    for (int i = 0; i < buyer.ownedCars().length; i++) {
                        if (buyer.ownedCars()[i] != null) {
                            freeGarageSpaces--;
                        }
                    }
                }
                if (freeGarageSpaces == 0) throw new Exception("Kupujący nie ma miejsca w garażu.");


            //Checking whether buyer has enough cash

            if (buyer.cashAvailable() < price) throw new Exception("Kupujący nie ma wystarczającej ilości pieniędzy.");

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
                Transaction transaction = new Transaction(seller, buyer, price);
                ownerList.add(transaction);
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
            if (checkedTransaction.deviceOwner() == human || checkedTransaction.devicePreviousOwner() == human) {
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
            if (checkedTransaction.deviceOwner() == humanB && checkedTransaction.devicePreviousOwner() == humanA) {
                wasCarSold = true;
                break;
            }
        }
        return wasCarSold;
    }

    //Method returning number of car sales transactions
    public Integer numberOfTransactions()
    {
        return this.ownerList.size();
    }

    //Supplementary setter of sales transactions
    public void addTransaction(Transaction transaction)
    {
        this.ownerList.add(transaction);
    }
}
