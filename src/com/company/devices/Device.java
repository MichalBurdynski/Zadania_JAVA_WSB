package com.company.devices;

import com.company.Human;
import com.company.Soldable;

public abstract class Device implements Soldable {
    public String producer;
    public String model;
    public Integer yearOfProduction;


    //toString method
    public String toString()
    {
        return " producent: " + producer + " model: " + model + " rok produkcji: " + yearOfProduction;
    }

    //abstract method turnOn
    public abstract void turnOn();

    //sell method of interface Soldable
    public void sell(Human seller, Human buyer, Double price)
    {
    }

}
