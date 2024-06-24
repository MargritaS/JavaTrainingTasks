package org.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryUnitTests {
    @Test
    public void DesignerSalaryTest() {
        Designer designer = new Designer("Olexii", "Olexiev", 100.00, 10, -10.00);
        var salary = designer.countedSalary();
        assertEquals(0, salary);
    }
    @Test
    public void SalaryTest() {
        Manager manager1 = new Manager("Olexii", "Belov", (Double)200.00, 2);;
        Developer developer1 = new Developer("Vasiliy", "Ivanov", (Double)100.00, 2);
        Developer developer2 = new Developer("Ivan", "Vasilev", (Double)100.00, 5);
        Designer designer2 = new Designer("Irina", "Vasileva", (Double)100.00, 5, (Double)2.5);
        manager1.addEmployee(developer1);
        manager1.addEmployee(developer2);
        manager1.addEmployee(designer2);
        var salaryManager = manager1.countedSalary();
        var salaryDeveloper1 = developer1.countedSalary();
        var salaryDeveloper2 = developer2.countedSalary();
        var salaryDesigner1 = designer2.countedSalary();


        assertEquals(440, round(salaryManager));
        assertEquals(300, round(salaryDeveloper1));
        assertEquals(620.00, round(salaryDeveloper2));
        assertEquals(620.00, round(salaryDesigner1));
    }
private double round(Double value) {
        return Math.floor(value * 100) / 100;
}
}
