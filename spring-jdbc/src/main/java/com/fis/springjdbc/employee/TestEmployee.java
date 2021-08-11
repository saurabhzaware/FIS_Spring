package com.fis.springjdbc.employee;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmployee {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("daoexample.xml");
		EmployeeDAOImpl bean = context.getBean("employeeDao", EmployeeDAOImpl.class);

		System.out.println("===============================");
		System.out.println("Insert a Employee");
		Employee employee = new Employee();
		employee.setId(30);
		employee.setName("eraser");
		bean.insertEmployee(employee);
		System.out.println("===============================");
		System.out.println("Delete Employee");
		int id = 10;
		bean.deleteEmployee(id);
		System.out.println("===============================");
		System.out.println("Get Employee Based on Id");
		id = 11;
		Employee employeeById = bean.getEmployeeById(id);
		System.out.println(employeeById);
		System.out.println("===============================");
		System.out.println("Update Product");
		employee = new Employee();
		employee.setId(30);
		employee.setName("browneraser");
		bean.updateEmployee(employee);
		System.out.println("===============================");
		System.out.println("Get All Employee");
		System.out.println(bean.getAllEmployee());
		System.out.println("===============================");

		context.close();
	}
}
