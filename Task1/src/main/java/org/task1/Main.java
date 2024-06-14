package org.task1;

public class Main {
    public static void main(String[] args) {

        try {
            var department = new Department();
            var manager1 = new Manager("Olexii", "Belov", (float)200.00, 2);;
            var developer1 = new Developer("Vasiliy", "Ivanov", (float)100.00, 2);
            var developer2 = new Developer("Ivan", "Vasilev", (float)100.00, 5);
            var developer3 = new Developer("Pavel", "Ivanov", (float)100.00, 10);
            var designer1 = new Designer("Natalia", "Vasileva", (float)100.00, 5, (float)0.5);
            var designer2 = new Designer("Irina", "Vasileva", (float)100.00, 5, (float)2.5);
            manager1.addEmployee(developer1);
            manager1.addEmployee(developer2);
            manager1.addEmployee(developer3);
            manager1.addEmployee(designer1);
            manager1.addEmployee(designer2);
            department.addManager(manager1);

            department.giveSalary();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}