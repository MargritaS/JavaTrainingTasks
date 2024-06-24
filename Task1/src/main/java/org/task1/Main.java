package org.task1;

public class Main {
    public static void main(String[] args) {

        try {
            var department = new Department();
            var manager1 = new Manager("Olexii", "Belov", 200.00, 2);
            var developer1 = new Developer("Vasiliy", "Ivanov", 100.00, 2);
            var developer2 = new Developer("Ivan", "Vasilev", 100.00, 5);
            var developer3 = new Developer("Pavel", "Ivanov", 100.00, 10);
            var designer1 = new Designer("Natalia", "Vasileva", 100.00, 5, 0.5);
            var designer2 = new Designer("Irina", "Vasileva", 100.00, 5, 2.5);
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