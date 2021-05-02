package com.company.devices;

public class ElectricCar extends Car {

    private Double batteryCapacity;
    private Boolean hasCharger;

    //Constructors
    public ElectricCar(String producer, String model, Double batteryCapacity, Boolean hasCharger) {
        super(producer, model);
        this.batteryCapacity = batteryCapacity;
        this.hasCharger = hasCharger;
    }

    public ElectricCar(String producer, String model, Integer chassisNumber, Double batteryCapacity, Boolean hasCharger) {
        super(producer, model, chassisNumber);
        this.batteryCapacity = batteryCapacity;
        this.hasCharger = hasCharger;
    }

    //toString method containing fields from abstract class Car
    public String toString()
    {
        return "marka auta: " + producer + " model: " + model + " " + " zużycie energii: " + fuelConsumption + " wartość auta: " + carValue + " pojemność baterii: " + batteryCapacity + " czy ma ładowrkę na pokładzie: "+ hasCharger;
    }

    //Implementation abstract method refuel
    public void refuel() {
        System.out.println("Auto naładowane do pełna.");
    }
}
