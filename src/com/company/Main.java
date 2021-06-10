package com.company;

public class Main {

    public static void main(String[] args) {
// Creating Human class objects
        Human human1 = new Human();
        human1.firstName = "Andrzej";
        human1.lastName = "Nowak";
        human1.pet = new Animal("pies");
        human1.phone = "Iphone";

        // Creating Animal class objects
        Animal dog1 = new Animal("pies");
        dog1.name = "Azorek";
        Animal cat1 = new Animal("kot");
        cat1.name = "Puszek";
        Animal crocodile1 = new Animal("krokodyl");
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
        Car car1 = new Car("Tesla", "Model 3");
        car1.fuelConsumption = 5.5;
        car1.numberOfPistons = 4;

        //Associating car1 to human1
        human1.ownedCar = car1;
    }
}
