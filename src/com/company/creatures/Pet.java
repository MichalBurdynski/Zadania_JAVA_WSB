package com.company.creatures;

public class Pet extends Animal {

    public boolean isVaccined;

    public Pet(String species, boolean isVaccined) {
        super(species);
        this.isVaccined = isVaccined;
    }

    public Pet(String species) {
        super(species);
    }
}
