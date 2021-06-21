package com.company.creatures;

import com.company.devices.Car;
import com.company.devices.Phone;

import java.util.Date;
import java.util.Objects;

public class Human extends Animal{
    public static final String DEFAULT_HUMAN_SPECIES = "Homo sapiens sapiens";
    public String firstName;
    public String lastName;
    public Animal pet;
    public Phone phone;
    private Car car;
    private Double salary = 0.0;
    public Double cash = 0.0;

    private Date dateOfLastSalaryChecking;

    public Human() {
        super(DEFAULT_HUMAN_SPECIES);
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

    public Car getCar()
    {
        return this.car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return firstName.equals(human.firstName) && lastName.equals(human.lastName) && Objects.equals(pet, human.pet) && Objects.equals(phone, human.phone) && Objects.equals(car, human.car) && Objects.equals(salary, human.salary) && Objects.equals(dateOfLastSalaryChecking, human.dateOfLastSalaryChecking) && Objects.equals(previousSalary, human.previousSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, pet, phone, car, salary, dateOfLastSalaryChecking, previousSalary);
    }

    public void setCar(Car car)
    {
        if (car == null)
        {
            this.car = null;
        }
        else if (this.salary > car.carValue)
        {
            System.out.println("Samochód kupiony za gotówkę.");
            this.car = car;
        }
        else if (this.salary > (car.carValue/12.0))
        {
            System.out.println("Samochód kupiony na kredyt.");
            this.car = car;
        }
        else
        {
            System.out.println("Auto za drogie. Zmień pracę lub poproś o podwyżkę.");
        }

    }

    @Override
    public String toString() {
        return "Human{" +
                "species='" + species + '\'' +
                ", pic=" + pic +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pet=" + pet +
                ", phone=" + phone +
                ", car=" + car +
                ", salary=" + salary +
                ", cash=" + cash +
                ", dateOfLastSalaryChecking=" + dateOfLastSalaryChecking +
                ", previousSalary=" + previousSalary +
                '}';
    }
}
