package com.company;

import com.company.creatures.*;
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
        human1.phone = "Iphone";

        // Creating Animal class objects
        Pet dog1 = new Pet("pies");
        dog1.name = "Azorek";
        Pet cat1 = new Pet("kot");
        cat1.name = "Puszek";
        Pet crocodile1 = new Pet("krokodyl");
        crocodile1.name = "Zębuś";

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

        System.out.println();

        //Creating object car1 and setting its fields.
        Car car1 = new ElectricCar("Tesla", "Model 3", 45.0, false);
        car1.fuelConsumption = 5.5;
        car1.value = 30000.0;

        //Associating car1 to human1
        //human1.ownedCar = car1; <- commented due to change modifier to private from public

        //Testing setter SalaryRise and getter CheckSalary
        //Salary Rise No1
        human1.salaryRise(15000.0);

        System.out.println();

        //SalaryCheck No1
        Double salary1 = human1.checkSalary();

        System.out.println();

        //SalaryCheck No2
        Double salary2 = human1.checkSalary();

        System.out.println();

        //Salary Rise No2
        human1.salaryRise(25000.0);

        System.out.println();

        //SalaryCheck No3
        Double salary3 = human1.checkSalary();

        System.out.println();

        //SalaryCheck No4
        Double salary4 = human1.checkSalary();

        System.out.println();

        //Testing 'ifCarAvailable' setter
        car1.value = 15000.0;
        human1.ifCarAvailable(car1);

        System.out.println();

        car1.value = 30000.0;
        human1.ifCarAvailable(car1);

        System.out.println();

        car1.value = 300000.0;
        human1.ifCarAvailable(car1);

        System.out.println();

        //Testing 'equals' method
        Car car2 = new LPGCar("Honda","Jazz", 30.0);
        Car car3 = new LPGCar("Honda","Jazz", 30.0);

        System.out.println(car2.equals(car3));
        System.out.println(new LPGCar("Honda", "Jazz", 0.0).equals(car3));

        System.out.println();

        //Testing 'hashCode' method
        Car car4 = new DieselCar("Volkswagen", "Golf", 12345, false);
        Car car5 = new DieselCar("Volkswagen", "Golf", 12345, false);
        Car car6 = new DieselCar("Volkswagen", "Golf", 12347, false);
        System.out.println(car4.hashCode() == car5.hashCode());
        System.out.println(car4.hashCode() == car6.hashCode());

        System.out.println();

        //Direct printing object fields in console - execution of overridden method 'toString'
        System.out.println(human1);

        System.out.println();

        System.out.println(car2);

        System.out.println();

        System.out.println(car4);

        System.out.println();

        //Testing abstract class Device

        Device car7 = new DieselCar("Skoda", "Fabia", false);
        car7.turnOn();
        System.out.println(car7);

        System.out.println();

        Device phone2 = new Phone();
        phone2.turnOn();
        System.out.println(phone2);

        System.out.println();

        Device car8 = new Device() {
            @Override
            public void turnOn() {
                System.out.println("Moje nowe auto zostało uruchomione.");
            }
        };
        car8.producer = "Ford";
        car8.model = "Fiesta";
        car8.yearOfProduction = 1998;
        System.out.println(car8);
        car8.turnOn();

        System.out.println();

        //Testing interface 'Soldable' and its method 'sell'
        //Creating supplementary objects and setting their fields.
        Human humanselling = new Human();
        humanselling.addCash(10000.0);
        Human humanbuying = new Human();
        humanbuying.addCash(10000.0);

        //Setting dog2 as 'humanselling' pet
        Animal dog2 = new Pet("pies");
        humanselling.pet = dog2;

        //Printing full information about 'humanselling' and 'humanbuying' objects in console before executing 'sell' method
        System.out.println("Dane przed sprzedażą zwierzaka\n");
        System.out.println("Dane sprzedającego:\n");
        System.out.println(humanselling);
        System.out.println("Dane kupującego:\n");
        System.out.println(humanbuying);
        System.out.println();

        //Selling dog
        dog2.sell(humanselling, humanbuying, 5000.0);

        //Printing full information about 'humanselling' and 'humanbuying' objects in console after executing 'sell' method
        System.out.println("Dane po sprzedaży zwierzaka\n");
        System.out.println("Dane sprzedającego:\n");
        System.out.println(humanselling);
        System.out.println("Dane kupującego:\n");
        System.out.println(humanbuying);
        System.out.println();

        //Creating car9 object and setting it to 'humanselling' object using setter setCar
        Car car9 = new DieselCar("Skoda", "Octavia", false);
        car9.value = 6000.0;
        humanselling.setCar(car9,1);
        car9.addTransaction(new Transaction(humanbuying, humanselling, 4000.0));
        System.out.println("Dane przed sprzedażą auta\n");

        //Printing full information about 'humanselling' and 'humanbuying' objects in console before executing 'sell' method
        System.out.println("Dane sprzedającego:\n");
        System.out.println(humanselling);
        System.out.println("Dane kupującego:\n");
        System.out.println(humanbuying);
        System.out.println();

        //Selling car
        try {
            car9.sell(humanselling, humanbuying, 4000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        //Printing full information about 'humanselling' and 'humanbuying' objects in console after executing 'sell' method
        System.out.println("Dane po sprzedaży auta\n");
        System.out.println("Dane sprzedającego:\n");
        System.out.println(humanselling);
        System.out.println("Dane kupującego:\n");
        System.out.println(humanbuying);
        System.out.println();

        //Testing abstract class Animal and its inherited class FarmingAnimal and Pet
        Animal swine1 = new Pet("swinka towarzyska");
        Animal swine2 = new FarmAnimal("pyszna swinka");
        FarmAnimal swine3 = new FarmAnimal("pyszna swinka1");

        //Testing method 'beEaten' of interface 'Edible'. It is executed on both objects, but is implemented in inherited class FarmingAnimal
        //The method cannot be executed objects of abstract class Animal without casting it to inherited class FarmingAnimal
        ((FarmAnimal) swine2).beEaten();
        swine3.beEaten();

        System.out.println();

        //Testing method 'feed' without parameter (Defaults Pet = 0.6, Farming Animal = 1.5) on Pet and FarmingAnimal class objects
        swine1.feed();
        swine2.feed();

        System.out.println();

        //Testing method 'feed' with parameter on Pet and FarmingAnimal class objects
        swine1.feed(2.0);
        swine2.feed(2.0);

        System.out.println();

        //Testing overloading method installAnnApp
        //Creating phone for a test
        Phone phone3 = new Phone();

        //Overloading installAnnApp method with different parameters
        phone3.installAnnApp("Soccer Manager");
        phone3.installAnnApp("Soccer Manager", "15.0");
        phone3.installAnnApp("Soccer Manager", "15.0", "https://google.com/SoccerManager.jar");
        ArrayList<String> applicationList = new ArrayList<String>();
        applicationList.add("Soccer Manager");
        applicationList.add("Car Race");
        applicationList.add("City Builder");
        applicationList.add("Messenger Call");
        phone3.installAnnApp(applicationList);
        try {
            URL url1 = new URL("https", "www.wp.pl", "wp.exe");
            phone3.installAnnApp(url1);
        } catch (MalformedURLException e) {
                 }
        try {
            URL url2 = null;
            phone3.installAnnApp(url2);
        } catch (MalformedURLException e) {
                 }
        try {
            URL url3 = new URL(Phone.DEFAULT_PROTOCOL, Phone.DEFAULT_SERVER_ADDRESS, Phone.DEFAULT_FILENAME);
            phone3.installAnnApp(url3);
        }
        catch (MalformedURLException e)
        {
        }

        System.out.println();

        //Testing method refuel
        Car car10 = new ElectricCar("Tesla", "Model 5", 45.0,true);
        Car car11 = new DieselCar("Ford", "Mondeo", true);
        Car car12 = new LPGCar("Renault", "Clio",36.0);
        car10.refuel();
        car11.refuel();
        car12.refuel();


        System.out.println("Test garażu");

        //Testing garage functions

        //Executing constructor with parameter garageCapacity
        Human human4 = new Human(8);
        human4.addCash(10000.0);
        human1.addCash(30000.0);

        //Creating Car class objects
        ElectricCar car13 = new ElectricCar("Renault","Zoe",45.0,true);
        car13.fuelConsumption = 12.0;
        car13.value = 20000.0;
        car13.yearOfProduction = 2018;
        car13.addTransaction(new Transaction(human1, human4, 4000.0));

        ElectricCar car14 = new ElectricCar("Renault","Clio",45.0,true);
        car14.fuelConsumption = 12.0;
        car14.value = 25000.0;
        car14.yearOfProduction = 2017;
        car14.addTransaction(new Transaction(human1, human4, 4000.0));

        ElectricCar car15 = new ElectricCar("Renault","Kadjar",60.0,false);
        car15.fuelConsumption = 15.0;
        car15.value = 17000.0;
        car15.yearOfProduction = 2021;
        car15.addTransaction(new Transaction(human1, human4, 4000.0));

        ElectricCar car16 = new ElectricCar("Renault","Kadjar",60.0,false);
        car16.fuelConsumption = 15.0;
        car16.value = 17000.0;
        car16.yearOfProduction = 2019;
        car16.addTransaction(new Transaction(human1, human4, 4000.0));

        ElectricCar car17 = new ElectricCar("Renault","Kadjar",60.0,false);
        car17.fuelConsumption = 15.0;
        car17.value = 17000.0;
        car17.yearOfProduction = 2020;
        car17.addTransaction(new Transaction(human1, human4, 4000.0));

        ElectricCar car18 = new ElectricCar("Renault","Kadjar",60.0,false);
        car18.fuelConsumption = 15.0;
        car18.value = 17000.0;
        car18.yearOfProduction = 2016;
        car18.addTransaction(new Transaction(human1, human4, 4000.0));

        ElectricCar car19 = new ElectricCar("Renault","Kadjar",60.0,false);
        car19.fuelConsumption = 15.0;
        car19.value = 17000.0;
        car19.yearOfProduction = 2015;
        car19.addTransaction(new Transaction(human1, human4, 4000.0));

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
        try {
            car12.sell(human4, human1, 30000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        //Trying to buy car when buyer does not have enough cash
        try {
            car13.sell(human4, human1, 50000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        //Trying to sell car that human does not have
        try {
            car13.sell(human1, human4, 5000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        //Trying to sell too much cars
        try {
            car13.sell(human4, human1, 1000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car14.sell(human4, human1, 1000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car15.sell(human4, human1, 2000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car16.sell(human4, human1, 3000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car17.sell(human4, human1, 2000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car18.sell(human4, human1, 1000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        try {
            car19.sell(human4, human1, 1000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

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
        System.out.println("Sprawdzenie czy human1 był kiedykolwiek posiadaczem auta car15\n");
        System.out.println(car15.wasCarOwner(human1));

        //Checking whether humanselling was the owner of car15
        System.out.println("Sprawdzenie czy humanselling był kiedykolwiek posiadaczem auta car15\n");
        System.out.println(car15.wasCarOwner(humanselling));

        //Checking whether human1 sold car15 to human4
        System.out.println("Sprawdzenie czy human1 kiedykolwiek sprzedał human4 auto car15\n");
        System.out.println(car15.wasCarSold(human1, human4));

        //Checking whether human4 sold car15 to humanbuying
        System.out.println("Sprawdzenie czy human4 kiedykolwiek sprzedał humanbuying auto car15\n");
        System.out.println(car15.wasCarSold(human4, humanbuying));

        //Checking number of sales transaction of car15
        System.out.println("Sprawdzenie ilości transakcji sprzedaży auta car15\n");
        System.out.println(car15.numberOfTransactions());

        //Checking number of sales transaction of car7
        System.out.println("Sprawdzenie ilości transakcji sprzedaży auta car7\n");
        System.out.println( ((Car) car7).numberOfTransactions());

        //Checking number of sales transaction of car8
        System.out.println("Sprawdzenie ilości transakcji sprzedaży auta car6\n");
        System.out.println( ((Car) car6).numberOfTransactions());

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
        System.out.println("Ilość pieniędzy przed zakupami aplikacji: "+human1.cashAvailable());

        //Trying to install an application on phone that owner is not buyer
        try {
            phone3.installAnnApp(app1, human4);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //Trying to install an application that the owner of the phone can not buy due to lack of cash
        try {
            phone3.installAnnApp(app6, human1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        //Installing applications

        try {
            phone3.installAnnApp(app1, human1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            phone3.installAnnApp(app2, human1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            phone3.installAnnApp(app3, human1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        try {
            phone3.installAnnApp(app4, human1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        try {
            phone3.installAnnApp(app5, human1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //Printing information about available amount of cash in console after transactions
        System.out.println("Ilość pieniędzy  po zakupach aplikacji: "+human1.cashAvailable());

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

        //Testing improved 'sell' method in Phone class

        Phone phone5 = new Phone();
        Human human5 = new Human();
        Human human6 = new Human();
        human5.setPhone(phone5);
        human6.addCash(10000.0);

        //Printing full information about 'human5' and 'human6' objects in console
        System.out.println("Testy poprawionej wersji metody sell w klasie Phone");
        System.out.println(human5+"\n");
        System.out.println(human6+"\n");

        //Attempt to sell a phone, when buyer does not have enough cash
        try {
            phone5.sell(human5, human6, 20000.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //Attempt to sell a phone, that seller does not have
        try {
            phone5.sell(human6, human5, 3000.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


        try {
            phone5.sell(human5, human6, 3000.0);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        //Printing full information about 'human5' and 'human6' objects in console
        System.out.println("Dane po zakupach:\n");
        System.out.println(human5+"\n");
        System.out.println(human6+"\n");

        //Printing full information about 'human1' object in console
        System.out.println(human1);
    }
}
