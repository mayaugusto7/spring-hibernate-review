package com.mayaugusto.springdemo.rest;

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

import com.mayaugusto.springdemo.entity.Customer;
import com.mayaugusto.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	private CustomerService customerService;

	@Autowired
	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return this.customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = this.customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		// Also just in cadse the pass id in JSON ... set id to 0
		// This is force a save of new item ... instead of update
		theCustomer.setId(0);
		
		this.customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
		this.customerService.saveCustomer(theCustomer);
		
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		
		Customer customer = this.customerService.getCustomer(customerId);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		
		this.customerService.deleteCustomer(customerId);
		
		return "Deleted customer id - " + customerId;
	}
}
