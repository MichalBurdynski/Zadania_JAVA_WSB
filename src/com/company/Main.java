package com.company;

public class Main {

    public static void main(String[] args) {
    // Creating objects based on Class Human
        Human human1 = new Human();
        human1.firstName = "Andrzej";
        human1.firstName = "Nowak";
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

    }
}
