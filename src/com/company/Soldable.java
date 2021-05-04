package com.company;

//Interface Soldable with its method sell
public interface Soldable {
    void sell(Human seller, Human buyer, Double price) throws Exception;
}
