package com.company.creatures;

import com.company.Human;
import com.company.Soldable;

import java.io.File;

public abstract class Animal implements Soldable, Feedable {
    final public String species;
    protected Double weight;
    public String name;
    File pic;

    //constant values of animal weight and amount of food its eats
    static final public Double DEFAULT_ANIMAL_WEIGHT = 1.0;
    static final public Double DEFAULT_FOOD_WEIGHT = 0.3;

    //Constructor with parameter species_ that depending on its value setting appropriate value to field weight
    Animal(String species_)
    {
        this.species = species_;
        if (this.species == "pies") {
            this.weight = 10.0;
        }
        else if (this.species == "kot") {
                this.weight = 2.0;
        }
        else
        {
            this.weight = DEFAULT_ANIMAL_WEIGHT;
        }
    }

    /* Implementation of feed method of interface Feedable without parameter.
    The method took as parameter default amount of food to increase an animal weight. */
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

    //takeForAWalk method This method decrease Animal weight
    public void takeForAWalk()
    {
        if (this.weight <= 0.0)
        {
            System.out.println("Zwierze nie żyje");
        }
        else
        {
            this.weight -= 3.0;
            System.out.println("Zwierze wyprowadzone. Masa zwierzęcia wynosi: "+this.weight);
        }
    }

    //toString method
    public String toString()
    {
        return "gatunek zwierzęcia:" + species + "\nwaga: " + weight + "\nimię zwierzaka: " + name + "\nfotka zwierzaka: " + pic;
    }

    //Implementation sell method of interface Soldable
    public void sell(Human seller, Human buyer, Double price)
    {
        if(seller.pet == this && buyer.cashAvailable() > price) {
            seller.incomeCash(price);
            buyer.incomeCash(-price);
            buyer.pet = seller.pet;
            seller.pet = null;
            System.out.println("Zwierze sprzedane.");

        }
        else if (seller.pet != this)
        {
            System.out.println("Sprzedający nie ma sprzedawanego zwierzaka.");
        }
        else
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
    }


}


