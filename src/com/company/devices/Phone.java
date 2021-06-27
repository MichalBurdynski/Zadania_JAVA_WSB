package com.company.devices;

import com.company.creatures.Human;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Phone extends Device {

    public Double screenSize;
    public String phoneOSVersion;

    Set<Application> applicationSet;

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

    public Phone(String producer, String model, Integer yearOfProduction, Double value, Double screenSize, String phoneOSVersion) {
        super(producer, model, yearOfProduction, value);
        this.screenSize = screenSize;
        this.phoneOSVersion = phoneOSVersion;
        this.applicationSet = new HashSet<>();
    }

    @Override
    public void turnOn() {
        System.out.println("Telefon uruchomiony.");
    }

    //Implementation of the sell method of interface Saleable
    public void sell(Human seller, Human buyer, Double price)
    {
        if (seller.getPhone() == null)
        {
        System.out.println("Sprzedający nie ma telefonu, który próbuje sprzedać.");
        }
        else if (buyer.cash < price)
        {
        System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
        else if (buyer.cash >= price && seller.getPhone().equals(this)) {
            seller.cash += price;
            buyer.cash -= price;
            buyer.setPhone(seller.getPhone());
            seller.setPhone(null);
            System.out.println("Telefon sprzedany.");
        }
    }

    //Implementation of method installAnnApp with parameter appName
    public void installAnnApp(String appName)
    {
        this.installAnnApp(appName, DEFAULT_APP_VERSION);
    }

    //Implementation of methodinstallAnnApp with parameter appName and appVersion
    public void installAnnApp(String appName, String appVersion) {
        this.installAnnApp(appName, appVersion, DEFAULT_SERVER_ADDRESS);
    }

    //Implementation of method installAnnApp with parameter appName, appVersion and serverAddress
    public void installAnnApp(String appName, String appVersion, String serverAddress)
    {
        URL url;
        try {
            url = new URL(DEFAULT_PROTOCOL, serverAddress, DEFAULT_PORT, appName + "-" + appVersion);
            this.installAnnApp(url);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    //Implementation of method installAnnApp with parameter appList
    public void installAnnApp(ArrayList<String> appList)
    {
        for (String s : appList) {
            this.installAnnApp(s);
        }
    }

    //Implementation of method installAnnApp with an URL object as parameter

    //Constants with default protocol, server address, app name
    public static final String DEFAULT_PROTOCOL = "https";
    public static final String DEFAULT_SERVER_ADDRESS = "www.google.com";
    public static final String DEFAULT_FILENAME = "app.jar";
    public static final String DEFAULT_APP_VERSION = "10.5";
    public static final Integer DEFAULT_PORT = 8080;

    //When URL is null method uses default values
    public void installAnnApp(URL url)  {
        System.out.println("Próbuję pobrać aplikację.");
        System.out.println("Zainstalowano aplikację o nazwie: " + url.getFile() + " z serwera o adresie: " + url.getHost());
    }

    //method instalAnnApp with parameter Application and buyer
    public void installAnnApp(Application application, Human buyer)
    {
        //Checking whether buyer is the owner of the phone
        boolean isOwner = false;
        try {
            if (this.equals(buyer.getPhone())) {
                isOwner = true;
            }

            if (!isOwner) {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
            System.out.println("Kupujący nie ma telefonu.");
        }

        //Check if owner has enough cash, then install the application
        try {
            if (buyer.cash < application.priceOfApplication)
            {
               throw new Exception();
            }
        }
        catch (Exception e)
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
        if (isOwner && buyer.cash >= application.priceOfApplication)
        {
            this.applicationSet.add(application);
            buyer.cash -= application.priceOfApplication;
            System.out.println("Aplikacja została zainstalowana.");
        }
    }

    //method isInstalledApp with Application object as parameter, checks whether application is installed
    public boolean isInstalledApp(Application application)
    {
        return applicationSet.contains(application);
    }

    //method isInstalledApp with parameter applicationname, checks whether application is installed
    public boolean isInstalledApp(String applicationName)
    {
        boolean isInstalled = false;
        if (!applicationSet.isEmpty())
        {
            for (Application checkedApplication: applicationSet)
            {
                if (Objects.equals(checkedApplication.nameOfApplication, applicationName))
                {
                    isInstalled = true;
                    break;
                }
            }
        }
        return isInstalled;
    }

    //method listFreeApp prints in console all installed free applications
    public void listFreeApp()
    {
        if (!applicationSet.isEmpty())
        {
            System.out.println("Lista zainstalowanych darmowych aplikacji:\n");
            for (Application checkedApplication: applicationSet)
            {
                if (checkedApplication.priceOfApplication == 0.0)
                {
                    System.out.println(checkedApplication);
                }
            }
        }
        else
        {
            System.out.println("Nie ma zainstalowanych żadnych aplikacji.");
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "screenSize=" + screenSize +
                ", phoneOSVersion='" + phoneOSVersion + '\'' +
                ", applicationSet=" + applicationSet +
                "} " + super.toString();
    }

    //method valueOfInstalledApplications prints in console value of all installed applications
    public void valueOfInstalledApplications()
    {
        double value = 0.0;
        if (!applicationSet.isEmpty())
        {
            for (Application checkedApplication: applicationSet)
            {
                value += checkedApplication.priceOfApplication;
            }
            System.out.println("Wartość zainstalowanych aplikacji wynosi:" + value);
        }
        else
        {
            System.out.println("Nie ma zainstalowanych żadnych aplikacji.");
        }
    }

    //method listInstalledApplicationAlphabetically lists all installed application in alphabetical order
    public void listInstalledApplicationAlphabetically()
    {
        if (!applicationSet.isEmpty())
        {
            Application[] tempList = applicationSet.toArray(new Application[0]);

            Arrays.sort(tempList, Comparator.comparing(app -> app.nameOfApplication));

            System.out.println("Aplikacje posortowane wg nazw alfabetycznie:");

            for (Application application: tempList
            ) { System.out.println(application); }
        }
        else
        {
            System.out.println("Nie ma zainstalowanych żadnych aplikacji.");
        }
    }

    //method listInstalledApplicationByAscendingPrices lists all installed application alphabetically
    public void listInstalledApplicationByAscendingPrices() {
        if (!applicationSet.isEmpty()) {
            Application[] tempList = applicationSet.toArray(new Application[0]);

            Arrays.sort(tempList, Comparator.comparing(app -> app.priceOfApplication));

            System.out.println("Aplikacje posortowane rosnąco wg cen :");

            for (Application application : tempList
            ) {
                System.out.println(application);
            }
        } else {
            System.out.println("Nie ma zainstalowanych żadnych aplikacji.");
        }
    }
}
