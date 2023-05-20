package com.learningspring.jdbcconnection.repository.interfaces;

import com.learningspring.jdbcconnection.entity.Employee;

public interface EmployeeDAO {
    void save(Employee newEmployee);
}
