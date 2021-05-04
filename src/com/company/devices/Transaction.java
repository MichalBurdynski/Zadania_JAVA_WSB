package com.company.devices;

import com.company.Human;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private final Human peopleSelling;
    private final Human peopleBuying;
    private final double price;
    private final Date dateTransaction;

    public Transaction(Human peopleSelling, Human peopleBuying, double price)
    {
        this.peopleSelling = peopleSelling;
        this.peopleBuying = peopleBuying;
        this.price = price;
        this.dateTransaction = new Date();
    }


    //Getter returning owner of the device
    public Human deviceOwner()
    {
        return this.peopleBuying;
    }

    public Human devicePreviousOwner()
    {
        return this.peopleSelling;
    }

    //toString method
    @Override
    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        String simpleDate = dateFormat.format(this.dateTransaction);
        return "\nOsoba sprzedająca: "+ this.peopleSelling.firstName + " " + this.peopleSelling.lastName  + "\nOsoba kupująca: "+ this.peopleBuying.firstName + " " + this.peopleBuying.lastName + "\nWartość transakcji: "+ this.price + "\nData transakcji: " + simpleDate +"\n";
    }

}
