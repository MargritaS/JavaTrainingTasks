package org.task1;

import java.math.BigDecimal;

public class Designer extends Employee {
    private Double effFact;

    public Designer(String name, String surname, Double baseSalary, Integer experience, Double effFact) {
        super(name, surname, baseSalary, experience);

        if (effFact < 0) {
            this.effFact = 0.0;
        }
        else if (effFact > 1) {
            this.effFact = 1.0;
        }
        else {
            this.effFact = effFact;
        }
    }
        public Double countedSalary () {
            return super.countedSalary() * this.effFact;
        }
    }
