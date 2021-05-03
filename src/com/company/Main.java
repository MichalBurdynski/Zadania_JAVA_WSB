package com.company;

import com.company.creatures.*;
import com.company.devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        // Creating objects based on Class Human
        Human human1 = new Human();
        human1.firstName = "Andrzej";
        human1.lastName = "Nowak";
        human1.pet = new Pet("pies");
        human1.phone = "Iphone";

        // Creating objects based on class Animal
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

        //SalaryCheck
        Double salary1 = human1.checkSalary();

        System.out.println();

        Double salary2 = human1.checkSalary();

        System.out.println();

        //Salary Rise No2
        human1.salaryRise(25000.0);

        System.out.println();

        //SalaryCheck No2
        Double salary3 = human1.checkSalary();

        System.out.println();

        Double salary4 = human1.checkSalary();

        System.out.println();

        //Testing ifCarAvailable setter
        car1.value = 15000.0;
        human1.ifCarAvailable(car1);

        System.out.println();

        car1.value = 30000.0;
        human1.ifCarAvailable(car1);

        System.out.println();

        car1.value = 300000.0;
        human1.ifCarAvailable(car1);

        System.out.println();

        //Testing equals method
        Car car2 = new LPGCar("Honda","Jazz", 30.0);
        Car car3 = new LPGCar("Honda","Jazz", 30.0);

        System.out.println(car2.equals(car3));
        System.out.println(new LPGCar("Honda", "Jazz", 0.0).equals(car3));

        System.out.println();

        //Testing hashCode method
        Car car4 = new DieselCar("Volkswagen", "Golf", 12345, false);
        Car car5 = new DieselCar("Volkswagen", "Golf", 12345, false);
        Car car6 = new DieselCar("Volkswagen", "Golf", 12347, false);
        System.out.println(car4.hashCode() == car5.hashCode());
        System.out.println(car4.hashCode() == car6.hashCode());

        System.out.println();

        //Direct printing in console fields of object - executing overridden method toString
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
        System.out.println(phone2.toString());

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
        System.out.println(car8.toString());
        car8.turnOn();

        System.out.println();

        //Testing interface Soldable and its method sell
        //Creating supplementary objects and setting their fields.
        Human humanselling = new Human();
        humanselling.addCash(10000.0);
        Human humanbuying = new Human();
        humanbuying.addCash(10000.0);

        //Setting dog2 as pet of humanselling
        Animal dog2 = new Pet("pies");
        humanselling.pet = dog2;

        //Printing in console fields of object humanselling and humanbuying
        System.out.println("Dane przed sprzedażą zwierzaka\n");
        System.out.println("Dane sprzedającego:\n");
        System.out.println(humanselling);
        System.out.println("Dane kupującego:\n");
        System.out.println(humanbuying);
        System.out.println();

        //Selling dog
        dog2.sell(humanselling, humanbuying, 5000.0);

        //Printing in console fields of object humanselling and humanbuying after executing sell method on dog2 object
        System.out.println("Dane po sprzedaży zwierzaka\n");
        System.out.println("Dane sprzedającego:\n");
        System.out.println(humanselling);
        System.out.println("Dane kupującego:\n");
        System.out.println(humanbuying);
        System.out.println();

        //Creating car9 object and setting it for humanselling object using setter setCar
        Car car9 = new DieselCar("Skoda", "Octavia", false);
        car9.value = 6000.0;
        humanselling.setCar(car9,1);

        System.out.println("Dane przed sprzedażą auta\n");

        //Printing in console fields of object humanselling and humanbuying
        System.out.println("Dane sprzedającego:\n");
        System.out.println(humanselling);
        System.out.println("Dane kupującego:\n");
        System.out.println(humanbuying);
        System.out.println();

        //Selling car
        try {
            car9.sell(humanselling, humanbuying, 4000.0);
        }
        catch (Exception e){};



        //Printing in console fields of object humanselling and humanbuying after executing sell method
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

        //Testing method beEaten of interface Edible. It is executed on both objects, but is implemented in inherited class FarmingAnimal
        //The method cannot be executed objects of abstract class Animal without casting it to inherited class FarmingAnimal
        ((FarmAnimal) swine2).beEaten();
        swine3.beEaten();

        System.out.println();

        //Testing method feed without parameter (Defaults Pet = 0.6, Farming Animal = 1.5) on objects of class Animal, Pet and FarmingAnimal
        swine1.feed();
        swine2.feed();

        System.out.println();

        //Testing method feed with parameter on objects of class Animal, Pet and FarmingAnimal
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

        ElectricCar car13 = new ElectricCar("Renault","Zoe",45.0,true);
        car13.fuelConsumption = 12.0;
        car13.value = 20000.0;
        car13.yearOfProduction = 2018;

        ElectricCar car14 = new ElectricCar("Renault","Clio",45.0,true);
        car14.fuelConsumption = 12.0;
        car14.value = 25000.0;
        car14.yearOfProduction = 2017;

        ElectricCar car15 = new ElectricCar("Renault","Kadjar",60.0,false);
        car15.fuelConsumption = 15.0;
        car15.value = 17000.0;
        car15.yearOfProduction = 2021;

        ElectricCar car16 = new ElectricCar("Renault","Kadjar",60.0,false);
        car16.fuelConsumption = 15.0;
        car16.value = 17000.0;
        car16.yearOfProduction = 2019;

        ElectricCar car17 = new ElectricCar("Renault","Kadjar",60.0,false);
        car17.fuelConsumption = 15.0;
        car17.value = 17000.0;
        car17.yearOfProduction = 2020;

        ElectricCar car18 = new ElectricCar("Renault","Kadjar",60.0,false);
        car18.fuelConsumption = 15.0;
        car18.value = 17000.0;
        car18.yearOfProduction = 2016;

        ElectricCar car19 = new ElectricCar("Renault","Kadjar",60.0,false);
        car19.fuelConsumption = 15.0;
        car19.value = 17000.0;
        car19.yearOfProduction = 2015;

        //Testing if possible is setting two cars at the same garage space
        human4.setCar(car13,0);
        human4.setCar(car13,0);

        human4.setCar(car14,1);
        human4.setCar(car15,2);
        human4.setCar(car16,3);
        human4.setCar(car17,4);
        human4.setCar(car18,5);
        human4.setCar(car19,6);

        //Test whether is possible place car in out of last index of array garage
        human4.setCar(car19,9);

        System.out.println();

        //Testing summing car values in garage
        human4.sumCarValue();
        human1.sumCarValue();

        System.out.println();

        //Testing new selling method

        //Printing in console fields of object human4 and human1
        System.out.println("Dane sprzedającego:");
        System.out.println(human4);
        System.out.println("Dane kupującego:");
        System.out.println(human1);
        System.out.println();

        //Selling car

        //Selling human does not have car12 in garage
        try {
            car12.sell(human4, human1, 30000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        //Buying human does not have appropriate amount of cash
        try {
            car13.sell(human4, human1, 50000.0);
        }
        catch (Exception e){
            System.out.println(e);
        }

        //Selling too much cars
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

        System.out.println();

        //Printing in console fields of object human4 and human1 after transactions
        System.out.println("Dane sprzedającego:");
        System.out.println(human4);
        System.out.println("Dane kupującego:");
        System.out.println(human1);
        System.out.println();

        //Testing sorting

        human1.sortCarByYearOfProduction();
        human4.sortCarByYearOfProduction();


        //Printing in console fields of object human4 and human1 after sorting
        System.out.println("Dane sprzedającego:");
        System.out.println(human4);
        System.out.println("Dane kupującego:");
        System.out.println(human1);
        System.out.println();

    }
}
