package com.company;

import java.io.File;

public class Animal {
    final public String species;
    private Double weight;
    public String name;
    File pic;

    static final  public Double DEFAULT_ANIMAL_WEIGHT = 1.0;

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

    public String toString()
    {
        return "gatunek zwierzęcia: " + species + " waga: " + weight + " imię zwierzaka: " + name + " fotka zwierzaka: " + pic;
    }
}


