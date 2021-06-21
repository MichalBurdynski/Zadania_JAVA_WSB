package com.company.creatures;

public class FarmAnimal extends Animal implements Edible{

    public boolean isCarnivore;

    public FarmAnimal(String species, boolean isCarnivore) {
        super(species);
        this.isCarnivore = isCarnivore;
    }

    public FarmAnimal(String species) {
        super(species);
    }

    public void beEaten()
    {
        System.out.println("Zwierze przygotowane do zjedzenia.");
        System.out.println("Zwierze zjedzone.");
    }

}
