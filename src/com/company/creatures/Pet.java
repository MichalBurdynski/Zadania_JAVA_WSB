package com.company.creatures;

public class Pet extends Animal implements Feedable {

    public Pet(String species_) {
        super(species_);
    }

    //constant values of amount of food Pet eats
    static final Double DEFAULT_FOOD_WEIGHT = 0.6;

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
}
