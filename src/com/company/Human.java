package com.company;

import com.company.creatures.Animal;
import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.ArrayList;
import java.util.Date;

public class Human {

    public String firstName;
    public String lastName;
    public Animal pet;
    protected String phone;
    private final ArrayList<Phone> ownedPhone;

    //Array of owned cars
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

    //Getter returning information of owned cars - if human has a cars, returns array of class Car objects, otherwise it return null.
    public Car[] humanCar()
    {
        return this.garage;
    }

    //Implementation of setter checking if car is available to buy
    public void ifCarAvailable(Car car_)
    {
        if (this.salary > car_.value)
        {
            System.out.println("Samochód kupiony za gotówkę.");
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
            System.out.println("Samochód kupiony na kredyt.");
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
            System.out.println("Auto za drogie. Zmień pracę lub poproś o podwyżkę.");
        }
    }

    //toString method Provide full information contained in fields of Human class object
    @Override
    public String toString()
    {

        //Printing details of cars, that are stored in garage
        String cars = "";
        for (int i = 0; i < garage.length; i++)
        {
            if (garage[i] != null)
            {
                cars += "Auto nr: "+i+'\n'+garage[i].toString() + '\n';
            }
        }
        if (cars == "")
        {
            cars = "Nie posiada auta.\n";
        }

        return  "Imię i nazwisko: " + firstName + " " + lastName + "\nPosiadane zwierze:\n" + pet + "\nPosiadane auta:\n" + cars + "Posiadane telefony " + ownedPhone + "\nZarobki: " + salary + "\nDostępne pieniądze: " + cash;

    }

    //Supplementary getter for interface 'Soldable' returning value of field 'cash'

    public Double cashAvailable()
    {
        return this.cash;
    }
    //Supplementary setter for interface 'Soldable' adding value of 'cash_' parameter to 'cash' field
    public void incomeCash(Double cash_)
    {
        this.cash += cash_;
    }

    //Supplementary getter for interface 'Soldable' returning array of Car class objects
    public Car[] ownedCars()
    {
        return this.garage;
    }

    //Default constructor
    public Human()
    {
        //Default garage capacity = 5
        this.garage = new Car[5];
        this.cash = 0.0;
        this.ownedPhone = new ArrayList<Phone>();
    }

    //Supplementary setter with 'cash_' parameter
    public void addCash(Double cash_)
    {
        this.cash += cash_;
    }

    //Supplementary constructor with 'garageCapacity' parameter
    Human(Integer garageCapacity)
    {
        //Garage capacity depends on parameter garageCapacity
        this.garage = new Car[garageCapacity];
        this.cash = 0.0;
        this.ownedPhone = new ArrayList<Phone>();
    }

    //Implementation of getter getCar returning Car class object from array 'garage' with index equal to garageSpaceNumber
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

    //Implementation of setter setCar setting Car class object in array 'garage' with index equal to garageSpaceNumber
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
            this.garage[garageSpaceNumber] = null;
        }
        else
        {
            System.out.println("Nie udało się wprowadzić samochodu na miejsce: "+garageSpaceNumber);
            System.out.println("W tym miejscu jest już auto:");
            System.out.println(garage[garageSpaceNumber]);
        }
    }

    //Implementation of method sumCarValue, adding up car values in 'garage' array
    public void sumCarValue()
    {
            Double sum = 0.0;
        for (Car car : garage) {

            if (car != null) {
                sum += car.value;
            }
        }
            System.out.println("Wartość posiadanych aut przez "+this.firstName + " "+ this.lastName+ " wynosi: "+sum);

    }

    /*Implementation of method sortCarByYearOfProduction, sorting out Car class objects
     in 'garage' array by value of 'yearOfProduction' field in ascending order*/
    //Bubble sort algorithm implemented due to small amount of cars
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

    //Getter returning Phone class object at specified index in 'ownedPhone' ArrayList for interface 'Soldable'
    public Phone getPhone(int number)
    {
        Phone returnedPhone = null;
        if (number <= this.ownedPhone.size()) {
            returnedPhone =  this.ownedPhone.get(number);
        }
        else
        {
            System.out.println("Podany numer miejsca jest wyższy niż ilość miejsc w szufladzie na telefony. Metoda zwróci pusty obiekt.");
        }
        return returnedPhone;
    }

    //Setter adding Phone class object to ArrayList 'ownedPhone'
    public void setPhone(Phone phone)
    {
        this.ownedPhone.add(phone);
    }

    //Setter removing Phone class object from the Arraylist 'ownedPhone' at the specified index
    public void removePhone(int number)
    {
        this.ownedPhone.remove(number);
    }

    //Getter returning list of owned phones
    public ArrayList<Phone> ownedPhones()
    {
        return this.ownedPhone;
    }

}
