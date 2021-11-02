package br.com.mayaugusto.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mayaugusto.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		
		Employee e1 = new Employee(1, "Maycon", "Augusto", "maycon@gmail.com");
		Employee e2 = new Employee(2, "Marcos", "Antônio", "marcos@gmail.com");
		Employee e3 = new Employee(3, "Rosemary", "Martins", "rosemary@gmail.com");
		
		employees = new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		theModel.addAttribute("employees", this.employees);
		
		return "list-employees";
	}
}
