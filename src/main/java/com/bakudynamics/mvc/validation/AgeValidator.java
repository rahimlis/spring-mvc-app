package com.bakudynamics.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AgeValidator implements ConstraintValidator<ValidAge, Date> {

    private int minAge;
    private int maxAge;

    @Override
    public void initialize(ValidAge constraintAnnotation) {
        minAge = constraintAnnotation.minAge();
        maxAge = constraintAnnotation.maxAge();
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if (minAge == 0 && maxAge == -1) return true;


        return checkMinAge(date) && checkMaxAge(date);
    }

    private boolean checkMaxAge(Date date) {

        Calendar minAgeConstraint = GregorianCalendar.getInstance();

        Calendar maxAgeConstraint = GregorianCalendar.getInstance();

        maxAgeConstraint.set(Calendar.YEAR, maxAgeConstraint.get(Calendar.YEAR) - maxAge);

        boolean valid = minAgeConstraint.getTime().before(date);

        if (!valid)
            System.out.println("Above age");

        return valid;
    }

    private boolean checkMinAge(Date date) {
        Calendar minAgeConstraint = GregorianCalendar.getInstance();

        minAgeConstraint.set(Calendar.YEAR, minAgeConstraint.get(Calendar.YEAR) - minAge);

        boolean valid = minAgeConstraint.getTime().after(date);

        if (!valid)
            System.out.println("Below age");

        return valid;
    }

}
