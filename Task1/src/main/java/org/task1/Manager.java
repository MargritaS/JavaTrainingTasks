package org.task1;

import java.util.ArrayList;

public class Manager extends Employee {
    public ArrayList<Employee> teamList;

    public Manager(String name, String surname, Double baseSalary, Integer experience) {
        super(name, surname, baseSalary, experience);
        teamList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        this.teamList.add(employee);
    }

    public Double countedSalary () {
        int numberOfDevs = 0;

        for (var item: teamList){
            if (item instanceof Developer){
                numberOfDevs++;
            }
        }

        Double salary = 0.0;
        if (teamList.size() >= 5 && teamList.size() < 10) {
            salary = super.countedSalary() + 200;
        } else if (teamList.size() >= 10) {
            salary = super.countedSalary() + 300;
        } else  {
            salary = super.countedSalary();
        }
        if (numberOfDevs >= teamList.size()/2) {
            salary = salary * (Double)1.1;
        }

        return salary;
    }
}
