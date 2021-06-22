package com.company.devices;

import com.company.creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class Phone extends Device {

    public Double screenSize;
    public String phoneOSVersion;

    @Override
    public String toString() {
        return "Phone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", screenSize=" + screenSize +
                ", phoneOSVersion='" + phoneOSVersion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return Objects.equals(screenSize, phone.screenSize) && Objects.equals(phoneOSVersion, phone.phoneOSVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(screenSize, phoneOSVersion);
    }

    public Phone(String producer, String model, Integer yearOfProduction, Double screenSize, String phoneOSVersion) {
        super(producer, model, yearOfProduction);
        this.screenSize = screenSize;
        this.phoneOSVersion = phoneOSVersion;
    }

    @Override
    public void turnOn() {
        System.out.println("Telefon uruchomiony.");
    }

    //Implementation of the sell method of interface Saleable
    public void sell(Human seller, Human buyer, Double price)
    {
        if (seller.phone == null)
        {
        System.out.println("Sprzedający nie ma telefonu, który próbuje sprzedać.");
        }
        else if (buyer.cash < price)
        {
        System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
        else if (buyer.cash >= price && seller.phone.equals(this)) {
            seller.cash += price;
            buyer.cash -= price;
            seller.phone = buyer.phone;
            seller.phone = null;
            System.out.println("Telefon sprzedany.");
        }
    }

    //Implementation of method installAnnApp with parameter appName
    public void installAnnApp(String appName)
    {
        System.out.println("Zainstalowano aplikację o nazwie: "+appName);
    }

    //Implementation of methodinstallAnnApp with parameter appName and appVersion
    public void installAnnApp(String appName, String appVersion)
    {
        System.out.println("Zainstalowano aplikację o nazwie: "+ appName +" w wersji: " + appVersion);
    }

    //Implementation of method installAnnApp with parameter appName, appVersion and serverAddress
    public void installAnnApp(String appName, String appVersion, String serverAddress)
    {
        System.out.println("Zainstalowano aplikację o nazwie: "+appName + " w wersji: " + appVersion + " z serwera o adresie: " + serverAddress);
    }

    //Implementation of method installAnnApp with parameter appList
    public void installAnnApp(ArrayList<String> appList)
    {
        for (String s : appList) {
            System.out.println("Zainstalowano aplikację o nazwie: " + s);
        }
    }

    //Implementation of method installAnnApp with an URL object as parameter

    //Constants with default protocol, server address, app name
    public static final String DEFAULT_PROTOCOL = "https";
    public static final String DEFAULT_SERVER_ADDRESS = "www.google.com";
    public static final String DEFAULT_FILENAME = "app.jar";

    //When URL is null method uses default values
    public void installAnnApp(URL specificAppURL) throws MalformedURLException {
        if (specificAppURL == null)
        {
            System.out.println("Nie podano prawidłowego adresu serwera z aplikacjami.");
            System.out.println("Zostanie zainstalowana aplikacja z domyślnego serwera.");
            URL newURL = new URL(DEFAULT_PROTOCOL, DEFAULT_SERVER_ADDRESS, DEFAULT_FILENAME);
            installAnnApp(newURL);
        }
        else {
            System.out.println("Zainstalowano aplikację o nazwie: " + specificAppURL.getFile() + " z serwera o adresie: " + specificAppURL.getHost());
        }
    }
}
