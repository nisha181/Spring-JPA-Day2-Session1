package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	
	private static void testGetEmployee() {

		LOGGER.info("Start");

		Employee employee = employeeService.get(1);

		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());

		LOGGER.info("End");
	}
	private static void testAddEmployee() {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("nisha");
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date(2020-07-10));
		employee.setSalary(33000);
        Department department=departmentService.get(1);
        employee.setDepartment(department);
        employeeService.save(employee);
	}
	
	private static void testUpdateEmployee() {
		Employee employee=employeeService.get(1);
		Department department=departmentService.get(3);
		employee.setDepartment(department);
		employeeService.save(employee);
	}
	
	private static void testGetDepartment() {
		Department department=departmentService.get(3);
		Set<Employee> employeeList=department.getEmployeeList();
	}
	
	private static void testAddSkillToEmployee() {
		Employee employee=employeeService.get(4);
		Skill skill=skillService.get(5);
		Set<Skill> skillList=employee.getSkillList();
		skillList.add(skill);
		employeeService.save(employee);
	}

	/*
	 * private static CountryService countryService;
	 * 
	 * private static void testGetAllCountries() {
	 * 
	 * LOGGER.info("Start");
	 * 
	 * List<Country> countries = countryService.getAllCountries();
	 * 
	 * LOGGER.debug("countries={}", countries);
	 * 
	 * LOGGER.info("End");
	 * 
	 * } private static void getAllCountriesTest() throws CountryNotFoundException {
	 * 
	 * LOGGER.info("Start"); Country country =
	 * countryService.findCountryByCode("IN");
	 * 
	 * LOGGER.debug("Country:{}", country);
	 * 
	 * LOGGER.info("End");
	 * 
	 * } private static void testAddCountry() { Country country=new
	 * Country("AA","ABC"); countryService.addCountry(country); try {
	 * countryService.findCountryByCode("AA"); } catch (CountryNotFoundException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * private static void testUpdateCountry() {
	 * countryService.updateCountry("AA","BCD"); }
	 * 
	 * private static void testDeleteCountry() { countryService.deleteCountry("AA");
	 * }
	 * 
	 * private static void testFindBySubString() { LOGGER.info("Start");
	 * System.out.println(countryService.namecontaining("ou")); LOGGER.info("Stop");
	 * }
	 * 
	 * private static void testFindByStartingwith() { LOGGER.info("Start");
	 * System.out.println(countryService.namestartswith("Z")); LOGGER.info("Stop");
	 * }
	 */

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

		// countryService = context.getBean(CountryService.class);
		//stockService = context.getBean(StockService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		/*
		 * testGetAllCountries(); try { getAllCountriesTest(); } catch
		 * (CountryNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } testAddCountry(); testUpdateCountry();
		 * testDeleteCountry(); //testFindBySubString(); //testFindByStartingwith();
		 */
		// System.out.println(stockService.getAllStock());
		// System.out.println(stockService.getDate());
		// System.out.println(stockService.getGoogle());
		// System.out.println(stockService.getMax());
		//System.out.println(stockService.getLowest());
		//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
		//testGetDepartment();
		testAddSkillToEmployee();
	}

}
