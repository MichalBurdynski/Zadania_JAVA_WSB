package com.company.devices;

public class Application {
    public final String nameOfApplication;
    public final String versionOfApplication;
    public final Double priceOfApplication;

    //Constructor

    public Application(String nameOfApplication, String versionOfApplication, double priceOfApplication)
    {
        this.nameOfApplication = nameOfApplication;
        this.versionOfApplication = versionOfApplication;
        this.priceOfApplication = priceOfApplication;
    }

    //toString method
    @Override
    public String toString()
    {
        return "\nNazwa aplikacji:\n"+ nameOfApplication + "\nWersja aplikacji:\n" + versionOfApplication +"\nWartość aplikacji:\n" +this.priceOfApplication+"\n";
    }
}
