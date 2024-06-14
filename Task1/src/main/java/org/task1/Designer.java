package org.task1;

import java.math.BigDecimal;

public class Designer extends Employee {
    private Float effFact;

    public Designer(String name, String surname, Float baseSalary, Integer experience, Float effFact) {
        super(name, surname, baseSalary, experience);

        if (effFact < 0)
            this.effFact = (float)0.0;
        if (effFact > 1)
            this.effFact = (float)1.0;
        this.effFact = effFact;
    }
        public Float countedSalary () {
            return super.countedSalary() * effFact;
        }
    }
