package com.company.devices;

import com.company.Human;
import com.company.Soldable;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Phone extends Device implements Soldable {
    Double screenSize;
    String OSVersion;

    Set<Application> applicationSet;

    //to String method including abstract class Device fields
    public String toString()
    {
        String applicationInfo;
        if(!applicationSet.isEmpty())
        {
            applicationInfo = "Lista aplikacji:\n"+applicationSet;
        }
        else
        {
            applicationInfo = " Nie zainstalowano żadnych aplikacji.";
        }
        return "\nMarka telefonu: " + producer + "\nModel: " + model + "\nRozmiar ekranu: " + screenSize + "\nwersja systemu operacyjnego: " + OSVersion + "\n" + applicationInfo +"\n";
    }


    //Implementation of abstract turnOn method
    public void turnOn()
    {
        System.out.println("Telefon uruchomiony");
    }

    //Implementation of interface Soldable
    public void sell(Human seller, Human buyer, Double price) throws Exception
    {
        //Checking whether seller has a phone in garage and is the owner
        boolean isOwner = false;
        int indexInOwnedPhone = -1;
        for (int i = 0; i < seller.ownedPhones().size(); i++) {
            Phone transactionItem = seller.ownedPhones().get(i);

            if (transactionItem == this) { isOwner = true; indexInOwnedPhone = i; break; }
        }

        if (!isOwner) throw new Exception("Sprzedający nie ma telefonu.");

        //Checking whether buyer has appropriate amount of cashAvailable

        if (buyer.cashAvailable() < price) throw new Exception("Kupujący nie ma wystarczającej ilości pieniędzy");

        seller.incomeCash(price);
        buyer.incomeCash(-price);
        Phone soldPhone = seller.getPhone(indexInOwnedPhone);
        buyer.setPhone(soldPhone);
        seller.removePhone(indexInOwnedPhone);
        System.out.println("Telefon sprzedany.");
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

    //Default constructor including applicationSet HashSet initialization
    public Phone()
    {
        this.applicationSet = new HashSet<>();
    }

    //method instalAnnApp with parameter Application and buyer
    public void installAnnApp(Application application, Human buyer) throws Exception
    {
        //Checking whether buyer is the owner of the phone
        boolean isOwner = false;
        for (int i = 0; i < buyer.ownedPhones().size(); i++) {
            Phone transactionItem = buyer.ownedPhones().get(i);

            if (transactionItem == this) { isOwner = true; break; }
        }
        if (!isOwner) throw new Exception("Kupujący nie ma telefonu.");

        //Check if owner has enough cash, then install the application
        if (buyer.cashAvailable() >= application.priceOfApplication)
        {
            this.applicationSet.add(application);
            buyer.incomeCash(-application.priceOfApplication);
            System.out.println("Aplikacja została zainstalowana.");
        }
        else
        {
            throw new Exception("Kupujący nie ma wystarczającej ilości pieniędzy.");
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

           for (int i = 0; i < tempList.length; i++)
            {
                for (int j = i+1; j < tempList.length; j++)
                {
                    if (tempList[i].nameOfApplication.compareTo(tempList[j].nameOfApplication) > 0)
                    {
                        Application temp = tempList[i];
                        tempList[i] = tempList[j];
                        tempList[j] = temp;
                    }
                }
            }
            System.out.println("Aplikacje posortowane wg nazw alfabetycznie:\n");

            for (Application application: tempList
                 ) { System.out.println(application); }
        }
        else
        {
            System.out.println("Nie ma zainstalowanych żadnych aplikacji.");
        }
    }

    //method listInstalledApplicationByAscendingPrices lists all installed application alphabetically
    public void listInstalledApplicationByAscendingPrices()
    {
        if (!applicationSet.isEmpty())
        {
            Application[] tempList = applicationSet.toArray(new Application[0]);
            for (int i = 0; i < tempList.length; i++)
            {
                for (int j = i+1; j < tempList.length; j++)
                {
                    if (tempList[i].priceOfApplication > tempList[j].priceOfApplication)
                    {
                        Application temp = tempList[i];
                        tempList[i] = tempList[j];
                        tempList[j] = temp;
                    }
                }
            }
            System.out.println("Aplikacje posortowane wg cen od najniższych:\n");
            for (Application application: tempList
            ) {
                System.out.println(application);
            }
        }
        else
        {
            System.out.println("Nie ma zainstalowanych żadnych aplikacji.");
        }
    }
}
