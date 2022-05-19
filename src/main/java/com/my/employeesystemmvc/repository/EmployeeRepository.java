package com.my.employeesystemmvc.repository;


import com.my.employeesystemmvc.model.Employee;

import java.util.List;

public interface EmployeeRepository  {

    public List<Employee> findAll();

    public Employee findById(Integer id);

    public Employee updateOrSave(Employee employee);

    public void delete(Integer id);

    public List findByEmail(String email);

}
