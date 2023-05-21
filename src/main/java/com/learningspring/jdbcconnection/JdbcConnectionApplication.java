package com.learningspring.jdbcconnection;

import com.learningspring.jdbcconnection.entity.Employee;
import com.learningspring.jdbcconnection.repository.EmployeeCRUD;
import com.learningspring.jdbcconnection.repository.interfaces.EmployeeDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class JdbcConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcConnectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner cmdRunner(EmployeeDAO employeeDAO){
		return runner -> getEmployeeByFirstName(employeeDAO);
	}

	private void createEmployee(EmployeeDAO employeeDAO){
		Employee newEmployee = new Employee("Arpit", "Das", "arpitdas118@gmail.com");
		Employee newEmployee2 = new Employee("Madhurima", "Das", "madhuisgr8@gmail.com");
		Employee newEmployee3 = new Employee("A L", "Das", "aldas@gmail.com");
		employeeDAO.save(newEmployee);
		employeeDAO.save(newEmployee2);
		employeeDAO.save(newEmployee3);

	}

	private void getAllEmployees(EmployeeDAO employeeDAO){
		List<Employee> employeeList = employeeDAO.findAll();
		employeeList.stream().filter(Objects::nonNull).forEach(System.out::println);
	}

	private void getEmployeeByFirstName(EmployeeDAO employeeDAO){
		List<Employee> employeeList = employeeDAO.findByFirstName("Arpit");
		employeeList.stream().filter(Objects::nonNull).forEach(System.out::println);
	}

}
