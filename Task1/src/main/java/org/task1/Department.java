package org.task1;

import java.util.ArrayList;

public class Department {
    public ArrayList<Manager> managersList;
    public Department() {
        managersList = new ArrayList<>();
    }

    public void addManager(Manager manager){
        this.managersList.add(manager);
    }

    public void giveSalary() {
        for (var item : managersList) {
            System.out.println(item.printList());
            for (var empl: item.teamList){
                System.out.println(empl.printList());
            }
        }
    }
}
