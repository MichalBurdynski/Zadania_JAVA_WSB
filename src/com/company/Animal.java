package com.company;

import java.io.File;
import java.util.Objects;

public class Animal {
    final String species;
    private Double weight;
    String name;
    File pic;

    //constant values of animal weight and amount of food its eats
    static final public Double DEFAULT_ANIMAL_WEIGHT = 1.0;

    //Constructor with parameter species that depending on its value setting appropriate value to field weight
    Animal(String species)
    {
        this.species = species;
        if (Objects.equals(this.species, "pies")) {
            this.weight = 10.0;
        }
        else if (Objects.equals(this.species, "kot")) {
            this.weight = 2.0;
        }
        else
        {
            this.weight = DEFAULT_ANIMAL_WEIGHT;
        }
    }

    /* Implementation of feed method.
       The method takes as parameter default amount of food to increase an animal weight. */
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

    //takeForAWalk method This method decreases animal weight by 3.0.
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

}
