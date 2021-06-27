package com.company.devices;

import com.company.creatures.Human;

import java.time.LocalDate;

public class Transaction {
    private final Human peopleSelling;
    private final Human peopleBuying;
    private final double price;
    private final LocalDate dateTransaction;

    public Transaction(Human peopleSelling, Human peopleBuying, double price)
    {
        this.peopleSelling = peopleSelling;
        this.peopleBuying = peopleBuying;
        this.price = price;
        this.dateTransaction = LocalDate.now();
    }


    //Getter returning owner of the device
    public Human getDeviceOwner()
    {
        return this.peopleBuying;
    }

    public Human getDevicePreviousOwner()
    {
        return this.peopleSelling;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "peopleSelling=" + peopleSelling.firstName + " "+  peopleSelling.lastName +
                ", peopleBuying=" + peopleBuying.firstName + " " +peopleBuying.lastName +
                ", price=" + price +
                ", dateTransaction=" + dateTransaction.toString() +
                '}';
    }
}
