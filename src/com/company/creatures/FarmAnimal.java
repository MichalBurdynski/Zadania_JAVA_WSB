package com.company.creatures;

public class FarmAnimal extends Animal implements Edible, Feedable {

    public FarmAnimal(String species_) {
        super(species_);
    }

    //constant values of amount of food FarmingAnimal eats
    public static Double DEFAULT_FOOD_WEIGHT = 1.5;

    //Implementation of feed method of interface Feedable without parameter. The method took as parameter default amount of food to increase an animal weight.
    public void feed()
    {
        if (this.weight <= 0)
        {
            System.out.println("Zwierze nie żyje");
        }
        else
        {
            this.weight += DEFAULT_FOOD_WEIGHT;
            System.out.println("Zwierze nakarmione. Masa zwierzęcia wynosi: "+this.weight);
        }
    }

    //Implementation of feed method of interface Feedable using parameter foodWeight.
    public void feed(Double foodWeight)
    {
        if (this.weight <= 0)
        {
            System.out.println("Zwierze nie żyje");
        }
        else
        {
            this.weight += foodWeight;
            System.out.println("Zwierze nakarmione. Masa zwierzęcia wynosi: "+this.weight);
        }
    }

    //Implementation of method beEaten of interface Edible
    public void beEaten()
    {
        System.out.println("Zwierzak był smaczny.");
    }
}
