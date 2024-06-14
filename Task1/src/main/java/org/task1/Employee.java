package org.task1;

import java.math.BigDecimal;

public class Employee {
    public Employee(String name, String surname, Float baseSalary, Integer experience) {
        this.name = name;
        this.surname = surname;
        this.baseSalary = baseSalary;
        this.experience =experience;
    }

    public String name;
    public String surname;
    public Float baseSalary;
    public Integer experience;
    public Float countedSalary() {
        if (experience >= 2 && experience < 5) {
            return baseSalary + 200;
        }
        if (experience >= 5) {
            return baseSalary * (float)1.2 + 500;
        }
        return baseSalary;
    }
    public String printList(){
        return name + "  |     " + surname + "  |     " + countedSalary();
    }
}
