package com.learningspring.jdbcconnection.repository.interfaces;

import com.learningspring.jdbcconnection.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee newEmployee);

    List<Employee> findAll();

    List<Employee> findByFirstName(String firstName);
}
