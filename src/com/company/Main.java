package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
// Creating Human class objects
        Human human1 = new Human();
        human1.firstName = "Andrzej";
        human1.lastName = "Nowak";
        human1.pet = new Pet("pies");

        // Creating Animal class objects
        Animal dog1 = new Pet("pies");
        dog1.name = "Azorek";
        Animal cat1 = new Pet("kot");
        cat1.name = "Puszek";
        Animal crocodile1 = new Pet("krokodyl");
        crocodile1.name = "Zebus";

        //Testing feed and takeForAWalk method

        //dog1
        dog1.feed();
        dog1.feed();
        dog1.takeForAWalk();
        dog1.takeForAWalk();
        dog1.takeForAWalk();
        dog1.takeForAWalk();
        dog1.takeForAWalk();
        dog1.feed();
        dog1.takeForAWalk();

        System.out.println();

        //cat1

        cat1.feed();
        cat1.takeForAWalk();
        cat1.takeForAWalk();
        cat1.feed();
        cat1.takeForAWalk();

        System.out.println();

        //crocodile1
        crocodile1.feed();
        crocodile1.takeForAWalk();
        crocodile1.takeForAWalk();
        crocodile1.takeForAWalk();
        crocodile1.takeForAWalk();
        crocodile1.feed();

        //car1
        Car car1 = new Electric("Tesla", "Model 3", 2019, 12.5,
                30000.0, 47.5, true);

        //Associating car1 to human1
        //commented due to change access modifier to private from public
        //human1.car = car1;

        //Salary Rise No1
        human1.setSalary(15000.0);

        //SalaryCheck
        Double salary1 = human1.getSalary();
        System.out.println("Pierwsze sprawdzenie zarobków: " +salary1);
        Double salary2 = human1.getSalary();
        System.out.println("Drugie sprawdzenie zarobków: " +salary2);

        //Salary Rise No2
        human1.setSalary(25000.0);

        //SalaryCheck No2
        Double salary3 = human1.getSalary();
        System.out.println("Trzecie sprawdzenie zarobków: " +salary3);
        Double salary4 = human1.getSalary();
        System.out.println("Czwarte sprawdzenie zarobków: " +salary4);

        //Testing setter 'setCar'
        System.out.println();
        car1.value = 15000.0;
        human1.setCar(car1,0);

        System.out.println();

        car1.value = 30000.0;
        human1.setCar(car1,0);

        System.out.println();

        car1.value = 300000.0;
        human1.setCar(car1,0);

        System.out.println();

        //Testing getter 'getCar'
        Car car0 = human1.getCar(0);

        //Car equals method
        Car car2 = new LPG("Honda","Jazz", 2015, 5.0, 10000.0,
                36.0);
        Car car3 = new LPG("Honda","Jazz", 2015, 5.0, 10000.0,
                36.0);
        System.out.println(car2.equals(car3));
        System.out.println(new LPG("Honda","Jazz", 2015, 5.0, 10000.0,
                36.0).equals(car3));

        //Direct printing object fields in console - execution of overridden method 'toString'
        System.out.println(human1);
        System.out.println();
        System.out.println(car2);
        System.out.println();
        System.out.println(dog1);
        System.out.println();
        Phone phone1 = new Phone("Apple", "IPhone", 2020, 4500.0,6.0, "PolarBreak");
        System.out.println(phone1);

        //Testing turnOn method
        phone1.turnOn();
        car3.turnOn();
        System.out.println();

        //Testing sell method in the Saleable interface

        //Car

        //Human2 - seller, human3 - buyer
        Human human2 = new Human();
        Human human3 = new Human();
        human2.setSalary(25000.0);
        human3.setSalary(25000.0);
        human3.cash = 10000.0;
        human2.setCar(car2,1);

        //Printing out information about human2 i human3 before transaction of selling
        System.out.println(human2);
        System.out.println(human3);

        car2.sell(human2, human3, 100000.0);
        car2.sell(human3, human2, 10000.0);
        car2.sell(human2, human3, 8500.0);

        //Printing out information about human2 i human3 after the transaction of selling
        System.out.println(human2);
        System.out.println(human3);

        //Phone

        //Human2 - seller, human3 - buyer
        human3.cash = 10000.0;
        human2.setPhone(phone1);

        //Printing out information about human2 i human3 before transaction of selling
        System.out.println(human2);
        System.out.println(human3);

        phone1.sell(human2, human3, 100000.0);
        phone1.sell(human3, human2, 10000.0);
        phone1.sell(human2, human3, 8500.0);

        //Printing out information about human2 i human3 after the transaction of selling
        System.out.println(human2);
        System.out.println(human3);

        //Animal

        //Human2 - seller, human3 - buyer
        human3.cash = 10000.0;
        human2.pet = dog1;

        //Printing out information about human2 i human3 before transaction of selling
        System.out.println(human2);
        System.out.println(human3);

        dog1.sell(human2, human3, 100000.0);
        dog1.sell(human3, human2, 10000.0);
        dog1.sell(human2, human3, 8500.0);

        //Printing out information about human2 i human3 after the transaction of selling
        System.out.println(human2);
        System.out.println(human3);

        //Testing if it is possible to sell a human
        human2.sell(human2, human3, 5000.0);

        //Testing 'farmin'' part
        Animal krowa = new FarmAnimal("krowa");
        FarmAnimal byk = new FarmAnimal("krowa");
        Animal kotka = new Pet("kot");
        Pet kocur = new Pet("kot");

        byk.beEaten();

        byk.feed();
        byk.feed(50.0);

        kocur.feed();
        kocur.feed(0.3);

        human3.feed();
        human3.feed(2.2);

        //Testing overloading method installAnnApp
        //Creating phone for a test
        Phone phone3 = new Phone("Apple","IPhone", 2019, 2500.0, 6.0, "5.03");

        //Overloading installAnnApp method with different parameters
        phone3.installAnnApp("Soccer Manager");
        phone3.installAnnApp("Soccer Manager", "15.0");
        phone3.installAnnApp("Soccer Manager", "15.0", "google.com");
        ArrayList<String> applicationList = new ArrayList<>();
        applicationList.add("Soccer Manager");
        applicationList.add("Car Race");
        applicationList.add("City Builder");
        applicationList.add("Messenger Call");
        phone3.installAnnApp(applicationList);
        try {
            URL url1 = new URL("https", "www.wp.pl", "wp.exe");
            phone3.installAnnApp(url1);
        } catch (MalformedURLException e) { System.out.println("Błędny URL.");
        }
        try {
            URL url3 = new URL(Phone.DEFAULT_PROTOCOL, Phone.DEFAULT_SERVER_ADDRESS, Phone.DEFAULT_FILENAME);
            phone3.installAnnApp(url3);
        }
        catch (MalformedURLException e)
        {
            System.out.println("Błędny URL.");
        }

        System.out.println();

        //Testing method refuel
        Car car10 = new Electric("Tesla", "Model 5", 2019, 15.0,15000.0, 45.0, true);
        Car car11 = new Disel("Ford", "Mondeo", 2019, 5.5, 10000.0,true);
        Car car12 = new LPG("Renault", "Clio",2015, 6.2, 15000.0,36.0);
        car10.refuel();
        car11.refuel();
        car12.refuel();

        System.out.println("Test garażu");

        //Testing garage functions

        //Executing constructor with parameter garageCapacity
        Human human4 = new Human(8);
        human4.firstName = "Adam";
        human4.lastName = "Kowalski";
        human4.setSalary(35000.0);
        human4.cash = 10000.0;
        human1.cash = 30000.0;

        //Creating Car class objects
        Electric car13 = new Electric("Renault","Zoe",2018,20000.0,12.0, 45.0, true);
        Electric car14 = new Electric("Renault","Clio",2017,25000.0,12.0, 45.0, true);
        Electric car15 = new Electric("Renault","Kadjar",2021,17000.0,15.0, 60.0, false);
        Electric car16 = new Electric("Renault","Kadjar",2019,17000.0,15.0, 60.0, false);
        Electric car17 = new Electric("Renault","Kadjar",2020,17000.0,15.0, 60.0, false);
        Electric car18 = new Electric("Renault","Kadjar",2016,17000.0,15.0, 60.0, false);
        Electric car19 = new Electric("Renault","Kadjar",2015,17000.0,15.0, 60.0, false);
        car13.ownerList.add(new Transaction(human1, human4, 4000.0));
        car14.ownerList.add(new Transaction(human1, human4, 4000.0));
        car15.ownerList.add(new Transaction(human1, human4, 4000.0));
        car16.ownerList.add(new Transaction(human1, human4, 4000.0));
        car17.ownerList.add(new Transaction(human1, human4, 4000.0));
        car18.ownerList.add(new Transaction(human1, human4, 4000.0));
        car19.ownerList.add(new Transaction(human1, human4, 4000.0));



        //Testing if possible is putting two cars on the same garage space
        human4.setCar(car13,0);
        human4.setCar(car13,0);

        human4.setCar(car14,1);
        human4.setCar(car15,2);
        human4.setCar(car16,3);
        human4.setCar(car17,4);
        human4.setCar(car18,5);
        human4.setCar(car19,6);

        //Test whether is possible put car outside of last index of 'garage' array
        human4.setCar(car19,9);

        System.out.println();

        //Testing summation of car values in garage
        human4.sumCarValue();
        human1.sumCarValue();

        System.out.println();

        //Testing new selling method

        //Printing full information about 'human4' and 'human1'  in console before 'sell' transactions
        System.out.println("Dane sprzedającego:");
        System.out.println(human4);
        System.out.println("Dane kupującego:");
        System.out.println(human1);
        System.out.println();

        //Selling car

        //Trying to sell car that human does not have
            car12.sell(human4, human1, 30000.0);

        //Trying to buy car when buyer does not have enough cash
            car13.sell(human4, human1, 50000.0);

        //Trying to sell car that human does not have
            car13.sell(human1, human4, 5000.0);

        //Trying to sell too much cars
            car13.sell(human4, human1, 1000.0);
            car14.sell(human4, human1, 1000.0);
            car15.sell(human4, human1, 2000.0);
            car16.sell(human4, human1, 3000.0);
            car17.sell(human4, human1, 2000.0);
            car18.sell(human4, human1, 1000.0);
            car19.sell(human4, human1, 1000.0);

        //Printing full information about object 'human4' and 'human1' in console after transaction 'sell'
        System.out.println();
        System.out.println("Dane po sprzedaży aut:\n");
        System.out.println("Dane sprzedającego:");
        System.out.println(human4);
        System.out.println("Dane kupującego:");
        System.out.println(human1);
        System.out.println();

        //Testing sorting
        human1.sortCarByYearOfProduction();
        human4.sortCarByYearOfProduction();


        //Printing full information about object 'human4' and 'human1' in console after sorting
        System.out.println("Posortowane auta:\n");
        System.out.println("Dane sprzedającego:");
        System.out.println(human4);
        System.out.println("Dane kupującego:");
        System.out.println(human1);
        System.out.println();

        //Checking whether human1 was the owner of car15
        System.out.println("Sprawdzenie czy human1 był kiedykolwiek posiadaczem auta car19\n");
        System.out.println(car19.wasCarOwner(human1));

        //Checking whether humanselling was the owner of car15
        System.out.println("Sprawdzenie czy human4 był kiedykolwiek posiadaczem auta car19\n");
        System.out.println(car19.wasCarOwner(human4));

        //Checking whether human1 sold car15 to human4
        System.out.println("Sprawdzenie czy human1 kiedykolwiek sprzedał human4 auto car15\n");
        System.out.println(car15.wasCarSold(human1, human4));

        //Checking whether human4 sold car15 to humanbuying
        System.out.println("Sprawdzenie czy human4 kiedykolwiek sprzedał human1 auto car3\n");
        System.out.println(car3.wasCarSold(human4, human1));

        //Checking number of sales transaction of car15
        System.out.println("Sprawdzenie ilości transakcji sprzedaży auta car15\n");
        System.out.println(car15.getNumberOfTransactions());

        //Checking number of sales transaction of car7
        System.out.println("Sprawdzenie ilości transakcji sprzedaży auta car14\n");
        System.out.println( (car14).getNumberOfTransactions());

        //Checking number of sales transaction of car8
        System.out.println("Sprawdzenie ilości transakcji sprzedaży auta car3\n");
        System.out.println( (car3).getNumberOfTransactions());

        //Testting Application Class

        System.out.println("\nTesty klasy aplikacji\n");

        //Creating objects
        Application app1 = new Application("Arbuzy", "1.01", 5.0);
        Application app2 = new Application("Banany", "1.01", 10.0);
        Application app3 = new Application("Cebulki", "1.01", 0.0);
        Application app4 = new Application("Dyński", "1.01", 0.0);
        Application app5 = new Application("Agreściki", "1.01", 15.0);
        Application app6 = new Application("Ananasy", "1.01", 30000.0);

        //Setting phone3 for human1
        human1.setPhone(phone3);

        //Printing information about available amount of cash in console before transactions 'sell'
        System.out.println("Ilość pieniędzy przed zakupami aplikacji: "+human1.cash);

        //Trying to install an application on phone that owner is not buyer
        phone3.installAnnApp(app1, human4);


        //Trying to install an application that the owner of the phone can not buy due to lack of cash
        phone3.installAnnApp(app6, human1);

        //Installing applications
        phone3.installAnnApp(app1, human1);
        phone3.installAnnApp(app2, human1);
        phone3.installAnnApp(app3, human1);
        phone3.installAnnApp(app4, human1);
        phone3.installAnnApp(app5, human1);

        //Printing information about available amount of cash in console after transactions
        System.out.println("Ilość pieniędzy  po zakupach aplikacji: "+human1.cash);

        //Checking if the application is installed on the phone
        System.out.println("Czy zainstalowano na telefonie aplikację app1?");
        System.out.println(phone3.isInstalledApp(app1));
        System.out.println("Czy zainstalowano na telefonie aplikację app6?");
        System.out.println(phone3.isInstalledApp(app6));
        System.out.println("Czy zainstalowano na telefonie aplikację o nazwie Banany?");
        System.out.println(phone3.isInstalledApp("Banany"));
        System.out.println("Czy zainstalowano na telefonie aplikację o nazwie Sliwki?");
        System.out.println(phone3.isInstalledApp("Sliwki"));

        //Printing value of all installed applications
        phone3.valueOfInstalledApplications();

        //Printing list of all installed free applications
        phone3.listFreeApp();

        //Printing list of applications in alphabetical order
        phone3.listInstalledApplicationAlphabetically();

        //Printing list of applications in order of increasing application prices
        phone3.listInstalledApplicationByAscendingPrices();

        //Printing full information about 'human1' object in console
        System.out.println(human1);
    }
}