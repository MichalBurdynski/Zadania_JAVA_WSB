package com.company.devices;

import com.company.Human;
import com.company.Soldable;

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
}
