package br.com.mayaugusto.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mayaugusto.springboot.cruddemo.entity.Employee;
import br.com.mayaugusto.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return this.employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee employee = this.employeeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		employee.setId(0);
		
		this.employeeService.save(employee);
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		this.employeeService.save(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteById(@PathVariable int employeeId) {
		
		Employee employee = this.employeeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		this.employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
}
