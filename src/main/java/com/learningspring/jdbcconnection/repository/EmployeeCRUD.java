package com.learningspring.jdbcconnection.repository;

import com.learningspring.jdbcconnection.entity.Employee;
import com.learningspring.jdbcconnection.repository.interfaces.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> queries = entityManager.createQuery("FROM Employee order by firstName desc", Employee.class);
        return queries.getResultList();
    }

    @Override
    public List<Employee> findByFirstName(String firstName) {
        TypedQuery<Employee> queries = entityManager.createQuery("FROM Employee WHERE firstName=:fName order by id asc", Employee.class);
        queries.setParameter("fName", firstName);
        return queries.getResultList();
    }
}
