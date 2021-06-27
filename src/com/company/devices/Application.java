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

    @Override
    public String toString() {
        return "Application{" +
                "nameOfApplication='" + nameOfApplication + '\'' +
                ", versionOfApplication='" + versionOfApplication + '\'' +
                ", priceOfApplication=" + priceOfApplication +
                '}';
    }
}
