package com.learningspring.jdbcconnection.repository;

import com.learningspring.jdbcconnection.entity.Employee;
import com.learningspring.jdbcconnection.repository.interfaces.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeCRUD implements EmployeeDAO {
    EntityManager entityManager;

    public EmployeeCRUD(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Employee newEmployee) {
        entityManager.persist(newEmployee);
    }
}
