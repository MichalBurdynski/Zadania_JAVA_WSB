package com.company;

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

        //Associating car1 to human1
        human1.ownedCar = car1;

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
    }
}
