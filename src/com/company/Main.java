package com.company;

import com.company.creatures.Animal;
import com.company.creatures.FarmAnimal;
import com.company.creatures.Pet;
import com.company.devices.Car;
import com.company.devices.Device;
import com.company.devices.Phone;

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

        //Creating object car1 and setting its fields.
        Car car1 = new Car("Tesla", "Model 3");
        car1.fuelConsumption = 5.5;
        car1.numberOfPistons = 4;
        car1.carValue = 30000.0;

        //Associating car1 to human1
        //human1.ownedCar = car1; <- commented due to change modifier to private from public

        //Testing setter SalaryRise and getter CheckSalary
        //Salary Rise No1
        human1.salaryRise(15000.0);

        //SalaryCheck
        Double salary1 = human1.checkSalary();
        Double salary2 = human1.checkSalary();

        //Salary Rise No2
        human1.salaryRise(25000.0);

        //SalaryCheck No2
        Double salary3 = human1.checkSalary();
        Double salary4 = human1.checkSalary();

        //Testing ifCarAvailable setter
        car1.carValue = 15000.0;
        human1.ifCarAvailable(car1);
        car1.carValue = 30000.0;
        human1.ifCarAvailable(car1);
        car1.carValue = 300000.0;
        human1.ifCarAvailable(car1);

        //Testing equals method
        Car car2 = new Car("Honda","Jazz");
        car2.numberOfPistons = 4;
        Car car3 = new Car("Honda","Jazz");
        car3.numberOfPistons = 4;
        System.out.println(car2.equals(car3));
        System.out.println(new Car("Honda", "Jazz").equals(car3));

        //Testing hashCode method
                Car car4 = new Car("Volkswagen", "Golf", 12345);
        Car car5 = new Car("Volkswagen", "Golf", 12345);
        Car car6 = new Car("Volkswagen", "Golf", 12347);
        System.out.println(car4.hashCode() == car5.hashCode());
        System.out.println(car4.hashCode() == car6.hashCode());

        //Direct printing in console fields of object - executing overridden method toString
        System.out.println(human1);
        System.out.println(car2);
        System.out.println(car3);

        //Testing abstract class Device
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

        //Testing interface Soldable and its method sell
        //Creating supplementary objects and setting their fields.
        Human humanselling = new Human(10000.0);
        humanselling.salaryRise(10000.0);
        Human humanbuying = new Human(10000.0);
        humanbuying.salaryRise(10000.0);

        //Setting dog2 as pet of humanselling
        Animal dog2 = new Pet("pies");
        humanselling.pet = dog2;

        //Printing in console fields of object humanselling and humanbuying
        System.out.println(humanselling);
        System.out.println(humanbuying);

        //Selling dog
        dog2.sell(humanselling, humanbuying, 5000.0);

        //Printing in console fields of object humanselling and humanbuying after executing sell method
        System.out.println(humanselling);
        System.out.println(humanbuying);

        //Creating car9 object and setting it for humanselling object using setter ifCarAvailable
        Car car9 = new Car("Skoda", "Octavia");
        car9.carValue = 6000.0;
        humanselling.ifCarAvailable(car9);

        //Printing in console fields of object humanselling and humanbuying
        System.out.println(humanselling);
        System.out.println(humanbuying);

        //Selling car
        car9.sell(humanselling, humanbuying, 4000.0);

        //Printing in console fields of object humanselling and humanbuying after executing sell method
        System.out.println(humanselling);
        System.out.println(humanbuying);

        //Testing abstract class Animal and its inherited class FarmingAnimal and Pet
        Animal swine1 = new Pet("swinka towarzyska");
        Animal swine2 = new FarmAnimal("pyszna swinka");
        FarmAnimal swine3 = new FarmAnimal("pyszna swinka1");

        //Testing method beEaten of interface Edible. It is executed on both objects, but is implemented in inherited class FarmingAnimal
        //The method cannot be executed objects of abstract class Animal without casting it to inherited class FarmingAnimal
        ((FarmAnimal) swine2).beEaten();
        swine3.beEaten();

        //Testing method feed without parameter (Defaults Pet = 0.6, Farming Animal = 1.5) on objects of class Animal, Pet and FarmingAnimal
        swine1.feed();
        swine2.feed();

        //Testing method feed with parameter on objects of class Animal, Pet and FarmingAnimal
        swine1.feed(2.0);
        swine2.feed(2.0);
    }
}
