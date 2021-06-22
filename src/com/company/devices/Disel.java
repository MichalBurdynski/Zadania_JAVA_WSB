package com.company.devices;

public class Disel extends Car{

    public Boolean hasDieselParticulateFilter;

    //Implementation of abstract method refuel
    public void refuel() {
        System.out.println("Auto zatankowane do pełna olejem napędowym.");
    }

    public Disel(String producer, String model, Integer yearOfProduction, Double fuelConsumption, Double carValue, Boolean hasDieselParticulateFilter) {
        super(producer, model, yearOfProduction, fuelConsumption, carValue);
        this.hasDieselParticulateFilter = hasDieselParticulateFilter;
    }

    @Override
    public String toString() {
        return "Disel{" +
                "fuelConsumption=" + fuelConsumption +
                ", carValue=" + carValue +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", hasDieselParticulateFilter=" + hasDieselParticulateFilter +
                '}';
    }
}
