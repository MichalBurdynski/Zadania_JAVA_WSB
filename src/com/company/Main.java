package com.company;

import devices.Car;
import devices.Device;
import devices.Phone;

public class Main {

    public static void main(String[] args) {

        // Creating objects based on Class Human
        Human human1 = new Human();
        human1.firstName = "Andrzej";
        human1.lastName = "Nowak";
        human1.pet = new Animal("pies");
        human1.phone = "Iphone";

        // Creating objects based on class Animal
        Animal dog1 = new Animal("pies");
        dog1.name = "Azorek";
        Animal cat1 = new Animal("kot");
        cat1.name = "Puszek";
        Animal crocodile1 = new Animal("krokodyl");
        crocodile1.name = "Zębuś";

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

        //cat1

        cat1.feed();
        cat1.takeForAWalk();
        cat1.takeForAWalk();
        cat1.feed();
        cat1.takeForAWalk();

        //crocodile1
        crocodile1.feed();
        crocodile1.takeForAWalk();
        crocodile1.takeForAWalk();
        crocodile1.takeForAWalk();
        crocodile1.takeForAWalk();
        crocodile1.feed();

        //car1
        Car car1 = new Car("Tesla", "Model 3");
        car1.fuelConsumption = 5.5;
        car1.numberOfPistons = 4;
        car1.carValue = 30000.0;

        //Associating car1 to human1
        //human1.ownedCar = car1; <- commented due to change into private field from public

        //Salary Rise No1
        human1.SalaryRise(15000.0);

        //SalaryCheck
        Double salary1 = human1.CheckSalary();
        Double salary2 = human1.CheckSalary();

        //Salary Rise No2
        human1.SalaryRise(25000.0);

        //SalaryCheck No2
        Double salary3 = human1.CheckSalary();
        Double salary4 = human1.CheckSalary();

        //If Car Available
        car1.carValue = 15000.0;
        human1.IfCarAvailable(car1);
        car1.carValue = 30000.0;
        human1.IfCarAvailable(car1);
        car1.carValue = 300000.0;
        human1.IfCarAvailable(car1);

        //Car equals method
        Car car2 = new Car("Honda","Jazz");
        car2.numberOfPistons = 4;
        Car car3 = new Car("Honda","Jazz");
        car3.numberOfPistons = 4;
        System.out.println(car2.equals(car3));
        System.out.println(new Car("Honda", "Jazz").equals(car3));

        //Car hashCode method
        Car car4 = new Car("Volkswagen", "Golf", 12345);
        Car car5 = new Car("Volkswagen", "Golf", 12345);
        Car car6 = new Car("Volkswagen", "Golf", 12347);
        System.out.println(car4.hashCode() == car5.hashCode());
        System.out.println(car4.hashCode() == car6.hashCode());

        //Printing in console object
        System.out.println(human1);
        System.out.println(car2);
        System.out.println(car3);

        //Testing abstract class
        Device car7 = new Car("Skoda", "Fabia");
        car7.turnOn();
        System.out.println(car7.toString());
        Device phone2 = new Phone();
        phone2.turnOn();
        System.out.println(phone2.toString());
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

    }
}
