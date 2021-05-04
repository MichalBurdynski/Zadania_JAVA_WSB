package com.company.devices;

public class DieselCar extends Car{

    private Boolean hasDieselParticulateFilter;

    //Constructors
    public DieselCar(String producer, String model, Boolean hasDieselParticulateFilter) {
        super(producer, model);
        this.hasDieselParticulateFilter = hasDieselParticulateFilter;
    }

    public DieselCar(String producer, String model, Integer chassisNumber, Boolean hasDieselParticulateFilter) {
        super(producer, model, chassisNumber);
        this.hasDieselParticulateFilter = hasDieselParticulateFilter;
    }

    //toString method containing fields from abstract class Car
    @Override
    public String toString()
    {
        return super.toString()+ "\nczy ma DPF:" + hasDieselParticulateFilter;
    }

    //Implementation of abstract method refuel
    public void refuel() {
        System.out.println("Auto zatankowane do pełna olejem napędowym.");
    }
}
