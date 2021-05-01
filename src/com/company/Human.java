package com.company;

import com.company.creatures.Animal;
import com.company.devices.Car;
import com.company.devices.Device;
import com.company.devices.Phone;

import java.util.Date;

public class Human {

    public String firstName;
    public String lastName;
    public Animal pet;
    protected String phone;
    private Car ownedCar;
    private Phone ownedPhone;

    private Double salary;
    private Double cash;

    //field specified for CheckSalary getter
    private Date dateSalaryCheck;
    private Double previousSalary;

    //Check salary getter
    public Double checkSalary()
    {
        if (dateSalaryCheck == null)
        {
            System.out.println("Nigdy nie sprawdzano wysokości wypłaty");
        }
        else {
            System.out.println("Data sprawdzenia wysokości wypłaty: " + this.dateSalaryCheck);
            System.out.println("Wysokość wypłaty: " + this.previousSalary);
        }
        this.dateSalaryCheck = new Date();
        this.previousSalary = this.salary;

        return this.salary;
    }

    //Salary rise setter
    public void salaryRise(Double salary_)
    {
        if (salary_ > 0) {
            System.out.println("Dane zostały wysłane do systemu księgowego");
            System.out.println("Proszę odebrać aneks do umowy od pani Hani z kadr");
            System.out.println("ZUS i US zostały powiadomione o podwyżce. Nie ma sensu ukrywać podwyżki");
            this.salary = salary_;
        }
    }

    //Getter returning information of owned car - if human has a car it return object of class Car, else it return null
    public Car humanCar()
    {
        return this.ownedCar;
    }

    //Implementation of setter checking if car is available to buy
    public void ifCarAvailable(Car car_)
    {
        if (this.salary > car_.carValue)
        {
            System.out.println("Samochód kupiony za gotówkę");
            this.ownedCar = car_;
        }
        else if (this.salary > (car_.carValue/12.0))
        {
            System.out.println("Samochód kupiony na kredyt");
            this.ownedCar = car_;
        }
        else
        {
            System.out.println("Auto za drogie. Zmień pracę lub poproś o podwyżkę");
        }
    }

    //toString method. It checks if human has a car or pet and return appropriate information
    public String toString()
    {
        String statement = null;
        if (ownedCar != null && pet != null) {
            statement =  "Imię i nazwisko: " + firstName + " " + lastName + " posiadane zwierze: " + pet.toString() + " posiadane auto: " + ownedCar.toString() + " posiadany telefon: " + phone + " zarobki: " + salary + " dostępne pieniądze: " + cash;
        }
        else if (ownedCar == null && pet != null)
        {
            statement =  "Imię i nazwisko: " + firstName + " " + lastName + " posiadane zwierze: " + pet.toString() + " posiadane auto: brak posiadany telefon: " + phone + " zarobki: " + salary + " dostępne pieniądze: " + cash;
        }
        else if (ownedCar != null && pet == null)
        {
            statement = "Imię i nazwisko: " + firstName + " " + lastName + " posiadane zwierze: brak posiadane auto: " + ownedCar.toString() + " posiadany telefon: " + phone + " zarobki: " + salary + " dostępne pieniądze: " + cash;
        }
        else
        {
            statement = "Imię i nazwisko: " + firstName + " " + lastName + " posiadane zwierze: brak posiadane auto: brak posiadany telefon: " + phone + " zarobki: " + salary + " dostępne pieniądze: " + cash;
        }
        return statement;
    }

    //Supplementary getter for interface Soldable returning value of field cash

    public Double cash()
    {
        return this.cash;
    }
    //Supplementary setter for interface Soldable adding value of parameter cash_ to field cash;
    public void incomeCash(Double cash_)
    {
        this.cash += cash_;
    }

    //Supplementary getter for interface Soldable returning value of field ownedCar
    public Car ownedCar()
    {
        return this.ownedCar;
    }

    //Supplementary getter for interface Soldable returning value of field ownedCar
    public Phone ownedPhone()
    {
        return this.ownedPhone;
    }

    //Supplementary setter for interface Soldable setting parameter device_ to field ownedCar
    public void buyDevice(Device device_)
    {
        this.ownedCar = (Car)device_;
    }

    //Default constructor
    Human()
    {
    }

    //Supplementary constructor with parameter cash
    Human(Double cash_)
    {
        this.cash = cash_;
    }
}
