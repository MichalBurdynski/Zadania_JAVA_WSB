package com.company.creatures;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.*;

public class Human extends Animal{
    public static final String DEFAULT_HUMAN_SPECIES = "Homo sapiens sapiens";
    public static final Integer DEFAULT_GARAGE_SPACES = 5;
    public String firstName;
    public String lastName;
    public Animal pet;
    public Phone phone;
    private final Car[] garage;
    public int garageCapacity;

    private Double salary = 0.0;
    public Double cash = 0.0;

    private Date dateOfLastSalaryChecking;

    public Human() {
        super(DEFAULT_HUMAN_SPECIES);
        garage = new Car[DEFAULT_GARAGE_SPACES];
        this.garageCapacity = DEFAULT_GARAGE_SPACES;
    }

    public Human(Integer garageSpace) {
        super(DEFAULT_HUMAN_SPECIES);
        this.garage = new Car[garageSpace];
        this.garageCapacity = garageSpace;
    }

    private Double previousSalary;

    public Double getSalary()
    {
        if (dateOfLastSalaryChecking == null)
        {
            System.out.println("Nigdy nie sprawdzano wysokości wypłaty.");
        }
        else {
            System.out.println("Data sprawdzenia wysokości wypłaty: " + this.dateOfLastSalaryChecking);
            System.out.println("Wysokość wypłaty: " + this.previousSalary);
        }
        this.dateOfLastSalaryChecking = new Date();
        this.previousSalary = this.salary;

        return this.salary;
    }

    public void setSalary(Double salary)
    {
        if (salary > 0) {
            System.out.println("Dane zostały wysłane do systemu księgowego.");
            System.out.println("Proszę odebrać aneks do umowy od pani Hani z kadr.");
            System.out.println("ZUS i US zostały powiadomione o podwyżce. Nie ma sensu ukrywać podwyżki.");
            this.salary = salary;
        }
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
        else if (garageSpaceNumber <= this.garage.length && car == null) {
            this.garage[garageSpaceNumber] = null;
        }
        else if (garageSpaceNumber <= this.garage.length && garage[garageSpaceNumber] == null) {
            if (this.salary > car.value)
            {
                System.out.println("Samochód kupiony za gotówkę.");
                this.garage[garageSpaceNumber] = car;
            }
            else if (this.salary > (car.value/12.0))
            {
                System.out.println("Samochód kupiony na kredyt.");
                this.garage[garageSpaceNumber] = car;
            }
            else
            {
                System.out.println("Auto za drogie. Zmień pracę lub poproś o podwyżkę.");
            }
        }
        else
        {
            System.out.println("Nie udało się wprowadzić samochodu na miejsce: "+garageSpaceNumber);
            System.out.println("W tym miejscu jest już auto.");
        }
    }

    //Implementation of method sumCarValue, adding up car values in 'garage' array
    public void sumCarValue()
    {
        Double sum = 0.0;
        for (Car car : garage) {
            if (car == null) {
                continue;
            }
            sum += car.value;
        }
        System.out.println("Wartość posiadanych aut przez "+this.firstName + " "+ this.lastName+ " wynosi: "+sum);

    }

    /*Implementation of method sortCarByYearOfProduction, sorting out Car class objects
     in 'garage' array by value of 'yearOfProduction' field in ascending order*/
    public void sortCarByYearOfProduction() {
        Arrays.sort(garage, Comparator.nullsLast(Comparator.comparingInt(o -> o.yearOfProduction)));
        }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        if (!super.equals(o)) return false;
        Human human = (Human) o;
        return garageCapacity == human.garageCapacity && Objects.equals(firstName, human.firstName) && Objects.equals(lastName, human.lastName) && Objects.equals(pet, human.pet) && Objects.equals(phone, human.phone) && Arrays.equals(garage, human.garage) && Objects.equals(salary, human.salary) && Objects.equals(cash, human.cash) && Objects.equals(dateOfLastSalaryChecking, human.dateOfLastSalaryChecking) && Objects.equals(previousSalary, human.previousSalary);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), firstName, lastName, pet, phone, garageCapacity, salary, cash, dateOfLastSalaryChecking, previousSalary);
        result = 31 * result + Arrays.hashCode(garage);
        return result;
    }

    @Override
    public String toString() {
        //Printing details of cars, that are stored in garage
        StringBuilder cars = new StringBuilder();
        for (int i = 0; i < garage.length; i++)
        {
            if (garage[i] != null)
            {
                cars.append("Auto nr: ").append(i).append('\n').append(garage[i]).append('\n');
            }
        }
        if (cars.toString().equals(""))
        {
            cars = new StringBuilder("Nie posiada auta.\n");
        }

        return "Human{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pet=" + pet +
                ", phone=" + phone +
                ", garage=" + cars+
                ", garageCapacity=" + garageCapacity +
                ", salary=" + salary +
                ", cash=" + cash +
                ", dateOfLastSalaryChecking=" + dateOfLastSalaryChecking +
                ", previousSalary=" + previousSalary +
                "} ";
    }
}
