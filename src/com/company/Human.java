package com.company;

import java.util.Date;

public class Human {
    public String firstName;
    public String lastName;
    public Animal pet;
    protected String phone;
    private Car ownedCar;
    private Double salary;

    private Date dateSalaryCheck;
    private Double previousSalary;

    public Double CheckSalary()
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

    public void SalaryRise(Double salary_)
    {
        if (salary_ > 0) {
            System.out.println("Dane zostały wysłane do systemu księgowego");
            System.out.println("Proszę odebrać aneks do umowy od pani Hani z kadr");
            System.out.println("ZUS i US zostały powiadomione o podwyżce. Nie ma sensu ukrywać podwyżki");
            this.salary = salary_;
        }
    }

    public Car humanCar()
    {
        return this.ownedCar;
    }

    public void IfCarAvailable(Car car_)
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
}
