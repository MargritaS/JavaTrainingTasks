package org.task1;

import java.math.BigDecimal;

public class Employee {
    public Employee(String name, String surname, Double baseSalary, Integer experience) {
        this.name = name;
        this.surname = surname;
        this.baseSalary = baseSalary;
        this.experience =experience;
    }

    public String name;
    public String surname;
    public Double baseSalary;
    public Integer experience;
    public Double countedSalary() {
        if (experience >= 2 && experience < 5) {
            return baseSalary + 200;
        }
        if (experience >= 5) {
            return baseSalary * (Double)1.2 + 500;
        }
        return baseSalary;
    }
    public String printList(){
        return name + "  |     " + surname + "  |     " + countedSalary();
    }
}
