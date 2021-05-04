package com.company.devices;

import com.company.Human;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    private Human peopleSelling;
    private Human peopleBuying;
    private double price;
    private Date dateTransaction;

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
        String string = "Osoba sprzedająca:\n"+ this.peopleSelling.firstName + " " + this.peopleSelling.lastName  + "\nOsoba kupująca:\n"+this.peopleBuying.firstName + " " + this.peopleBuying.lastName + "\nWartość transakcji:\n"+ this.price + "\nData transakcji:\n" + simpleDate;
        return string;
    }

}
