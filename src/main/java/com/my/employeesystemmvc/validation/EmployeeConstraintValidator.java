package com.my.employeesystemmvc.validation;

import com.my.employeesystemmvc.model.Employee;
import com.my.employeesystemmvc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmployeeConstraintValidator implements ConstraintValidator<CheckEmployee, Employee> {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeConstraintValidator(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext constraintValidatorContext) {
        if((employee.getEmail()).equals(employeeRepository.findById(employee.getId()).getEmail())){
            return true;
        }
        else{
            List employees = employeeRepository.findByEmail(employee.getEmail());
            return employees.isEmpty();
        }
    }
}
