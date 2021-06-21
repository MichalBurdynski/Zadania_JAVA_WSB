package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Human;
import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.Phone;

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
        Car car1 = new Car("Tesla", "Model 3", 2019, 5.5,
                4, 30000.0);

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
        car1.carValue = 15000.0;
        human1.setCar(car1);

        System.out.println();

        car1.carValue = 30000.0;
        human1.setCar(car1);

        System.out.println();

        car1.carValue = 300000.0;
        human1.setCar(car1);

        System.out.println();

        //Testing getter 'getCar'
        Car car0 = human1.getCar();

        //Car equals method
        Car car2 = new Car("Honda","Jazz", 2015, 5.0, 4,
                10000.0);
        Car car3 = new Car("Honda","Jazz", 2015, 5.0, 4,
                10000.0);
        System.out.println(car2.equals(car3));
        System.out.println(new Car("Honda","Jazz", 2015, 5.0, 4,
                10000.0).equals(car3));

        //Direct printing object fields in console - execution of overridden method 'toString'
        System.out.println(human1);
        System.out.println();
        System.out.println(car2);
        System.out.println();
        System.out.println(dog1);
        System.out.println();
        Phone phone1 = new Phone("Apple", "IPhone", 2020, 6.0, "PolarBreak");
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
        human2.setSalary(15000.0);
        human3.setSalary(15000.0);
        human3.cash = 10000.0;
        human2.setCar(car2);

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
        human2.phone = phone1;

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

    }
}