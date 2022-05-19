package com.my.employeesystemmvc.repository;

import com.my.employeesystemmvc.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List findAll() {

        List<EmployeeRepository> employees =  entityManager
                                    .createNativeQuery("Select * from Employee", Employee.class)
                                    .getResultList();

        return employees;
    }

    @Override
    public Employee findById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);

        return employee;
    }

    @Override
    public Employee updateOrSave(Employee employee) {

        Employee emp = entityManager.merge(employee);

        return employee;
    }

    @Override
    public void delete(Integer id) {

        Employee employee = entityManager.find(Employee.class, id);

        entityManager.remove(employee);

    }

    @Override
    public List findByEmail(String email) {
        Query query = entityManager
                .createNativeQuery("Select * from Employee where email = ?1", Employee.class);
        query.setParameter(1, email);

        return query.getResultList();
    }


}
