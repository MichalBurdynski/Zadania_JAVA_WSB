package com.company.devices;

public class LPGCar extends Car {

    private Double capacityLPGTank;

    //Constructors
    public LPGCar(String producer, String model, Double capacityLPGTank) {
        super(producer, model);
        this.capacityLPGTank = capacityLPGTank;
    }

    public LPGCar(String producer, String model, Integer chassisNumber, Double capacityLPGTank) {
        super(producer, model, chassisNumber);
        this.capacityLPGTank = capacityLPGTank;
    }

    //toString method containing fields from abstract class Car
    public String toString()
    {
        return super.toString() + "\nPojemność zbiornika LPG: "+capacityLPGTank;
    }

    //Implementation of abstract method refuel
    public void refuel() {
        System.out.println("Auto zatankowane do pełna gazem płynnym LPG.");
    }
}
