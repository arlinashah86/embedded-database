package my.com.arlinashah86.dao;

import java.util.List;

import my.com.arlinashah86.model.Employee;

public interface EmployeeDao {
	
	Employee findByName(String name);
	
	List<Employee> findAll();

}
