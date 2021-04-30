package com.company;

import java.io.File;

public class Animal implements Soldable {
    final public String species;
    private Double weight;
    public String name;
    File pic;

    static final  public Double DEFAULT_ANIMAL_WEIGHT = 1.0;

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

    //feed method
    public void feed()
    {
        if (this.weight <= 0)
        {
            System.out.println("Zwierze nie żyje");
        }
        else
        {
            this.weight += 1;
            System.out.println("Zwierze nakarmione. Masa zwierzęcia wynosi: "+this.weight);
        }
    }

    //takeForAWalk method
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
        return "gatunek zwierzęcia: " + species + " waga: " + weight + " imię zwierzaka: " + name + " fotka zwierzaka: " + pic;
    }

    //Implementation sell method of interface Soldable
    public void sell(Human seller, Human buyer, Double price)
    {
        if(seller.pet != null && buyer.cash() > price) {
            seller.incomeCash(price);
            buyer.incomeCash(-price);
            buyer.pet = seller.pet;
            seller.pet = null;
            System.out.println("Zwierze sprzedane.");

        }
        else if (seller.pet == null)
        {
            System.out.println("Sprzedający nie ma zwierzaka.");
        }
        else
        {
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        }
    }
}


