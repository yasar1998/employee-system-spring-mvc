package com.my.employeesystemmvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = EmployeeConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckEmployee {

    public String message();
    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default{};

}
