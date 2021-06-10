package com.company;

import java.util.Date;

public class Human {
    public String firstName;
    public String lastName;
    public Animal pet;
    public String phone;
    public Car ownedCar;

    private Double salary;

    private Date dateOfLastSalaryChecking;
    private Double previousSalary;

    public Double getSalary()
    {
        if (dateOfLastSalaryChecking == null)
        {
            System.out.println("Nigdy nie sprawdzano wysokości wypłaty");
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
            System.out.println("Dane zostały wysłane do systemu księgowego");
            System.out.println("Proszę odebrać aneks do umowy od pani Hani z kadr");
            System.out.println("ZUS i US zostały powiadomione o podwyżce. Nie ma sensu ukrywać podwyżki");
            this.salary = salary;
        }
    }
}
