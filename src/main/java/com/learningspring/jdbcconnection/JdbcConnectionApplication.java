package com.learningspring.jdbcconnection;

import com.learningspring.jdbcconnection.entity.Employee;
import com.learningspring.jdbcconnection.repository.EmployeeCRUD;
import com.learningspring.jdbcconnection.repository.interfaces.EmployeeDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdbcConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcConnectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdRunner(EmployeeDAO employeeDAO){
		return runner -> createEmployee(employeeDAO);
	}

	private void createEmployee(EmployeeDAO employeeDAO){
		Employee newEmployee = new Employee("Arpit", "Das", "arpitdas118@gmail.com");
		employeeDAO.save(newEmployee);
		System.out.println("Employee saved!!!");
		System.out.println("Id for employee: " + newEmployee.getId());
	}

}
