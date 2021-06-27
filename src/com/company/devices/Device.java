package com.company.devices;

import com.company.creatures.Human;
import com.company.Saleable;

public abstract class Device implements Saleable {
    public String producer;
    public String model;
    public Integer yearOfProduction;
    public Double value;

    @Override
    public String toString() {
        return "Device{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", value=" + value +
                '}';
    }

    public Device(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }

    //Declaration of an abstract method turnOn
    public abstract void turnOn();

    //Declaration of sell method of interface Saleable
    public void sell(Human seller, Human buyer, Double price) throws Exception {
    }
}
