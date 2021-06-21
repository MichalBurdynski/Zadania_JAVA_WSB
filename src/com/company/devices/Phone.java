package com.company.devices;

import com.company.Human;

import java.util.Objects;

public class Phone extends Device {

    public Double screenSize;
    public String phoneOSVersion;

    @Override
    public String toString() {
        return "Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", screenSize=" + screenSize +
                ", phoneOSVersion='" + phoneOSVersion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(screenSize, phone.screenSize) && Objects.equals(phoneOSVersion, phone.phoneOSVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenSize, phoneOSVersion);
    }

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, String phoneOSVersion) {
        super(producer, model, yearOfProduction);
        this.screenSize = screenSize;
        this.phoneOSVersion = phoneOSVersion;
    }

    @Override
    public void turnOn() {
        System.out.println("Telefon uruchomiony.");
    }

    //Implementation of the sell method of interface Saleable
    public void sell(Human seller, Human buyer, Double price)
    {
        if (seller.phone == null)
        {
        System.out.println("Sprzedający nie ma telefonu, który próbuje sprzedać.");
        }
        else if (buyer.cash < price)
        {
        System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
        else if (buyer.cash >= price && seller.phone.equals(this)) {
            seller.cash += price;
            buyer.cash -= price;
            seller.phone = buyer.phone;
            seller.phone = null;
            System.out.println("Telefon sprzedany.");
        }

    }
}
