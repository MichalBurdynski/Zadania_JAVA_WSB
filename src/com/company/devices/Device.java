package com.company.devices;

import com.company.Human;
import com.company.Soldable;

public abstract class Device implements Soldable {
    public String producer;
    public String model;
    public Integer yearOfProduction;
    public Double value;


    //toString method
    public String toString()
    {
        return "Producent: " + producer + "\nModel: " + model + "\nRok produkcji: " + yearOfProduction + "\nWartość:" + value ;
    }

    //Declaration of an abstract method turnOn
    public abstract void turnOn();

    //sell method of interface Soldable
    public void sell(Human seller, Human buyer, Double price) throws Exception {
    }

}
