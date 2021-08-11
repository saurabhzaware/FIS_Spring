package com.fis.springjdbc.employee;

import java.util.List;

import com.fis.springjdbc.employee.Employee;

public interface IEmployee {

	public void insertEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public void updateEmployee(Employee employee);

	public void deleteEmployee(int id);

	public Employee getEmployeeById(int id);
}
