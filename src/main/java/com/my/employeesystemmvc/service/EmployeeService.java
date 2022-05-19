package com.my.employeesystemmvc.service;


import com.my.employeesystemmvc.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void addRecord(Employee employee);

    public List<Employee> getAllRecords();

    public Employee getRecordById(Integer id);

    public Employee updateRecord(Employee employee);

    public void deleteRecord(Integer id);

    public List findRecordByEmail(String email);
}
