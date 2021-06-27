package com.company.devices;

import java.util.Objects;

public class LPG extends Car {

    public final Double capacityLPGTank;

    public LPG(String producer, String model, Integer yearOfProduction, Double value, Double fuelConsumption, Double capacityLPGTank) {
        super(producer, model, yearOfProduction, value, fuelConsumption);
        this.capacityLPGTank = capacityLPGTank;
    }

    //Implementation of abstract method refuel
    public void refuel() {
        System.out.println("Auto zatankowane do pełna gazem płynnym LPG.");
    }

    @Override
    public String toString() {
        return "LPG{" +
                "capacityLPGTank=" + capacityLPGTank +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LPG)) return false;
        if (!super.equals(o)) return false;
        LPG lpg = (LPG) o;
        return Objects.equals(capacityLPGTank, lpg.capacityLPGTank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacityLPGTank);
    }
}
