package com.company.devices;

public class Electric extends Car {

    public final Double batteryCapacity;
    public final Boolean hasCharger;

    public Electric(String producer, String model, Integer yearOfProduction, Double fuelConsumption, Double carValue, Double batteryCapacity, Boolean hasCharger) {
        super(producer, model, yearOfProduction, fuelConsumption, carValue);
        this.batteryCapacity = batteryCapacity;
        this.hasCharger = hasCharger;
    }

    @Override
    public String toString() {
        return "Electric{" +
                "fuelConsumption=" + fuelConsumption +
                ", carValue=" + carValue +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", batteryCapacity=" + batteryCapacity +
                ", hasCharger=" + hasCharger +
                '}';
    }

    //Implementation abstract method refuel
    public void refuel() {
        System.out.println("Auto naładowane do pełna.");
    }
}
