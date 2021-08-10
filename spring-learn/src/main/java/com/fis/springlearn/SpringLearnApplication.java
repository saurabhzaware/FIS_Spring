
package com.fis.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.springlearn.bean1.Employee;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(SpringLearnApplication.class, args);
//		displayDate();
//		displayCountry();
		displayEmployee();
	}

//	public static void displayCountries() {
//		LOGGER.info("");
//		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		Country country = context.getBean("countryList", Country.class);
//		for(int i=0;i<co)
//	}

	public static void displayCountry() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
//		Country country = context.getBean("country", Country.class);
//		Country anotherCountry = context.getBean("anotherCountry", Country.class);
//		LOGGER.debug(country.toString());
//		LOGGER.debug(anotherCountry.toString());

		ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
		LOGGER.debug("Countries : {}" + countryList);
		LOGGER.info("END");
	}
	
	static void displayEmployee() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		Employee employee = context.getBean("employee", Employee.class);
		LOGGER.debug("Employee : {}", employee);
		LOGGER.info("END");
	}
	
	static void displayDate() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date parseDate = format.parse("31/12/2018");
//			System.out.println(parseDate);
			LOGGER.debug(parseDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat format1 = context.getBean("dateFormat1", SimpleDateFormat.class);
		try {
			Date parseDate1 = format1.parse("08/09/2021");
//			System.out.println(parseDate1);
			LOGGER.debug(parseDate1.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("END");
	}

}
