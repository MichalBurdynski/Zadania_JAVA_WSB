package com.company.devices;

public class LPG extends Car {

    public final Double capacityLPGTank;

    public LPG(String producer, String model, Integer yearOfProduction, Double fuelConsumption, Double carValue, Double capacityLPGTank) {
        super(producer, model, yearOfProduction, fuelConsumption, carValue);
        this.capacityLPGTank = capacityLPGTank;
    }

    //Implementation of abstract method refuel
    public void refuel() {
        System.out.println("Auto zatankowane do pełna gazem płynnym LPG.");
    }

    @Override
    public String toString() {
        return "LPG{" +
                "fuelConsumption=" + fuelConsumption +
                ", carValue=" + carValue +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", capacityLPGTank=" + capacityLPGTank +
                '}';
    }
}
