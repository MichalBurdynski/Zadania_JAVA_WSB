package com.company;

import com.company.creatures.Animal;
import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.Date;

public class Human {

    public String firstName;
    public String lastName;
    public Animal pet;
    protected String phone;
    private Phone ownedPhone;

    //Arrays of owned cars
    private final Car[] garage;


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
            System.out.println("Poprzednia wysokość wypłaty: " + this.previousSalary);
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

    //Getter returning information of owned cars - if human has a car it return object of class Car, else it return null
    public Car[] humanCar()
    {
        return this.garage;
    }

    //Implementation of setter checking if car is available to buy
    public void ifCarAvailable(Car car_)
    {
        if (this.salary > car_.value)
        {
            System.out.println("Samochód kupiony za gotówkę");
            for (int i = 0; i < garage.length; i++)
            {
                if (garage[i] != null)
                {
                    garage[i] = car_;
                    break;
                }
            }
        }
        else if (this.salary > (car_.value/12.0))
        {
            System.out.println("Samochód kupiony na kredyt");
            for (int i = 0; i < garage.length; i++)
            {
                if (garage[i] != null)
                {
                    garage[i] = car_;
                    break;
                }
            }
        }
        else
        {
            System.out.println("Auto za drogie. Zmień pracę lub poproś o podwyżkę");
        }
    }

    //toString method. It checks if human has a car or pet and return appropriate information
    public String toString()
    {
        String statement = "";

        //Printing owned car details
        String cars = "";
            for (int i = 0; i < garage.length; i++)
            {
                if (garage[i] != null)
                {
                    cars += "Auto nr: "+i+'\n'+garage[i].toString() + '\n';
                }
            }

        if (cars != "" && pet != null) {
            statement =  "Imię i nazwisko: " + firstName + " " + lastName + "\nPosiadane zwierze:\n" + pet + "\nPosiadane auta:\n" + cars + "Posiadany telefon: " + phone + "\nZarobki: " + salary + "\nDostępne pieniądze: " + cash;
        }
        else if (cars == "" && pet != null)
        {
            statement =  "Imię i nazwisko: " + firstName + " " + lastName + "\nPosiadane zwierze:\n" + pet + "\nNie posiada auta.\nPosiadany telefon: " + phone + "\nZarobki: " + salary + "\nDostępne pieniądze: " + cash;
        }
        else if (cars != "" && pet == null)
        {
            statement =  "Imię i nazwisko: " + firstName + " " + lastName + "\nNie posiada zwierzęcia.\nPosiadane auta:\n" + cars + "Posiadany telefon: " + phone + "\nZarobki: " + salary + "\nDostępne pieniądze: " + cash;
        }
        else
        {
            statement =  "Imię i nazwisko: " + firstName + " " + lastName + "\nNie posiada zwierzęcia.\nNie posiada auta.\nPosiadany telefon: " + phone + "\nZarobki: " + salary + "\nDostępne pieniądze: " + cash;
        }
        return statement;
    }

    //Supplementary getter for interface Soldable returning value of field cashAvailable

    public Double cashAvailable()
    {
        return this.cash;
    }
    //Supplementary setter for interface Soldable adding value of parameter cash_ to field cashAvailable;
    public void incomeCash(Double cash_)
    {
        this.cash += cash_;
    }

    //Supplementary getter for interface Soldable returning array of object Car garage
    public Car[] ownedCars()
    {
        return this.garage;
    }

    //Supplementary getter for interface Soldable returning value of field ownedPhone
    public Phone ownedPhone()
    {
        return this.ownedPhone;
    }

    //Default constructor
    public Human()
    {
        //Default garage capacity = 5
        this.garage = new Car[5];
        this.cash = 0.0;
    }

    //Supplementary setter with parameter cash_
    public void addCash(Double cash_)
    {
        this.cash += cash_;
    }

    //Supplementary constructor with parameter garageCapacity
    Human(Integer garageCapacity)
    {
        //Garage capacity depends on parameter garageCapacity
        this.garage = new Car[garageCapacity];
        this.cash = 0.0;
    }

    //Implementation of getter getCar returning Car object from array garage at index equals to garageSpaceNumber
    public Car getCar(Integer garageSpaceNumber)
    {
        Car returnedCar = null;
        if (garageSpaceNumber <= this.garage.length) {
            returnedCar =  this.garage[garageSpaceNumber];
        }
        else
        {
            System.out.println("Podany numer miejsca jest większy niż rozmiar garażu. Metoda zwróci pusty obiekt.");
        }
        return returnedCar;
    }

    //Implementation of setter setCar setting Car object in array garage at index equals to garageSpaceNumber
    public void setCar(Car car, Integer garageSpaceNumber)
    {
        if (garageSpaceNumber > this.garage.length)
        {
            System.out.println("Nie można umieścić auta. Numer miejsca "+garageSpaceNumber+ " powyżej dopuszczalnej limitu miejsc: "+this.garage.length);
        }
        else if (garageSpaceNumber <= this.garage.length && garage[garageSpaceNumber] == null) {
            this.garage[garageSpaceNumber] = car;
        }
        else if (garageSpaceNumber <= this.garage.length && car == null) {
            this.garage[garageSpaceNumber] = car;
        }
        else
        {
            System.out.println("Nie udało się wprowadzić samochodu na miejsce: "+garageSpaceNumber);
            System.out.println("W tym miejscu jest już auto:");
            System.out.println(garage[garageSpaceNumber]);
        }
    }

    //Implementation of method sumCarValue setting sum of car values in garage to field value in Device class
    public void sumCarValue()
    {

            Double sum = 0.0;
            for (int i = 0; i < garage.length; i++)
            {

               if (garage[i] != null) {
                   sum += garage[i].value;
               }
            }
            System.out.println("Wartość posiadanych aut przez "+this.firstName + " "+ this.lastName+ " wynosi: "+sum);

    }

    //Implementation of method sortCarByYearOfProduction, sorting Car objects in array garage by ascending yearOfProduction
    //Implemented bubble sort algorithm by to small amount of cars
    public void sortCarByYearOfProduction()
    {
        for (int i = 0; i < garage.length; i++)
        {
            for (int j = i+1; j < garage.length; j++)
            {
                if (garage[i] != null &&garage[j] != null && garage[i].yearOfProduction > garage[j].yearOfProduction)
                {
                    Car car = garage[j];
                    garage[j] = garage[i];
                    garage[i] = car;
                }
            }
        }
    }

}
