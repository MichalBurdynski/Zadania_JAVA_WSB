package com.company.creatures;

import com.company.Saleable;

import java.io.File;
import java.util.Objects;

public abstract class Animal implements Saleable, Feedable {
    final String species;
    protected Double weight;
    public String name;
    public File pic;

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

    public void feed(double foodWeight)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return species.equals(animal.species) && weight.equals(animal.weight) && name.equals(animal.name) && Objects.equals(pic, animal.pic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, weight, name, pic);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", pic=" + pic +
                '}';
    }

    //Implementation sell method of interface Saleable
    public void sell(Human seller, Human buyer, Double price)
    {
        if (this instanceof Human)
        {
            System.out.println("Nie wolno sprzedać człowieka!!!");
        }
        else if (seller.pet == null)
            System.out.println("Sprzedający nie ma zwierzęcia, które próbuje sprzedać.");
        else if (buyer.cash < price)
            System.out.println("Kupujący nie ma wystarczającej ilości pieniędzy.");
        else if (seller.pet.equals(this) && buyer.cash >= price) {
            seller.cash = seller.cash + price;
            buyer.cash = buyer.cash - price;
            buyer.pet = seller.pet;
            seller.pet = null;
            System.out.println("Zwierze sprzedane.");
        }

    }
}
