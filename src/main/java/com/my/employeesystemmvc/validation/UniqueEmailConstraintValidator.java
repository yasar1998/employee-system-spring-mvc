package com.my.employeesystemmvc.validation;

import com.my.employeesystemmvc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class UniqueEmailConstraintValidator implements ConstraintValidator<UniqueEmail, String> {

    EmployeeRepository employeeRepository;

    @Autowired
    public UniqueEmailConstraintValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List employees = employeeRepository.findByEmail(s);
        return employees.isEmpty();
    }
}
