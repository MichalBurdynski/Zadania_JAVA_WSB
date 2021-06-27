package com.company.devices;

import java.util.Objects;

public class Disel extends Car{

    public Boolean hasDieselParticulateFilter;

    //Implementation of abstract method refuel
    public void refuel() {
        System.out.println("Auto zatankowane do pełna olejem napędowym.");
    }

    public Disel(String producer, String model, Integer yearOfProduction, Double value, Double fuelConsumption, Boolean hasDieselParticulateFilter) {
        super(producer, model, yearOfProduction, value, fuelConsumption);
        this.hasDieselParticulateFilter = hasDieselParticulateFilter;
    }

    @Override
    public String toString() {
        return "Disel{" +
                "hasDieselParticulateFilter=" + hasDieselParticulateFilter +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disel)) return false;
        if (!super.equals(o)) return false;
        Disel disel = (Disel) o;
        return Objects.equals(hasDieselParticulateFilter, disel.hasDieselParticulateFilter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasDieselParticulateFilter);
    }
}
