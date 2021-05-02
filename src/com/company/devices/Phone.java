package com.company.devices;

import com.company.Human;
import com.company.Soldable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Phone extends Device implements Soldable {
    Double screenSize;
    String OSVersion;

    //to String method including abstract class Device fields
    public String toString()
    {
        return "marka telefonu: " + producer + " model: " + model + " rozmiar ekranu: " + screenSize + " wersja systemu operacyjnego: " + OSVersion;
    }


    //Implementation of abstract turnOn method
    public void turnOn()
    {
        System.out.println("Telefon uruchomiony");
    }

    //Implementation of interface Soldable
    public void sell(Human seller, Human buyer, Double price)
    {
        if(seller.ownedPhone() != null && buyer.cash() > price) {
            seller.incomeCash(price);
            buyer.incomeCash(-price);
            buyer.buyDevice(seller.ownedPhone());
            seller.buyDevice(null);
            System.out.println("Urządzenie sprzedane.");

        }
        else if (seller.ownedPhone() == null)
        {
            System.out.println("Sprzedający nie ma urządzenia.");
        }
        else
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
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
        for (int i = 0; i < appList.size(); i++) {
            System.out.println("Zainstalowano aplikację o nazwie: " + appList.get(i));
        }
    }

    //Implementation of method installAnnApp with an URL object as parameter

    //Constants fields with default protocol, server address, app name
    public static final String DEFAULT_PROTOCOL = "https";
    public static final String DEFAULT_SERVER_ADDRESS = "www.google.com";
    public static final String DEFAULT_FILENAME = "app.jar";

    //When URL
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
