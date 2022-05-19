package com.my.employeesystemmvc.service;

import com.my.employeesystemmvc.model.Employee;
import com.my.employeesystemmvc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional
    public void addRecord(Employee employee) {
        employeeRepository.updateOrSave(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAllRecords() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public Employee getRecordById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    @Transactional
    public Employee updateRecord(Employee employee) {
        return employeeRepository.updateOrSave(employee);
    }

    @Override
    @Transactional
    public void deleteRecord(Integer id) {
        employeeRepository.delete(id);
    }

    @Override
    @Transactional
    public List findRecordByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

}
