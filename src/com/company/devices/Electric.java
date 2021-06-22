package com.company.devices;

import java.util.Objects;

public class Electric extends Car {

    public final Double batteryCapacity;
    public final Boolean hasCharger;

    public Electric(String producer, String model, Integer yearOfProduction, Double value, Double fuelConsumption, Double batteryCapacity, Boolean hasCharger) {
        super(producer, model, yearOfProduction, value, fuelConsumption);
        this.batteryCapacity = batteryCapacity;
        this.hasCharger = hasCharger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electric)) return false;
        if (!super.equals(o)) return false;
        Electric electric = (Electric) o;
        return Objects.equals(batteryCapacity, electric.batteryCapacity) && Objects.equals(hasCharger, electric.hasCharger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), batteryCapacity, hasCharger);
    }

    @Override
    public String toString() {
        return "Electric{" +
                "fuelConsumption=" + fuelConsumption +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", value=" + value +
                ", batteryCapacity=" + batteryCapacity +
                ", hasCharger=" + hasCharger +
                '}';
    }

    //Implementation abstract method refuel
    public void refuel() {
        System.out.println("Auto naładowane do pełna.");
    }
}
