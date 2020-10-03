package br.com.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.springdemo.entity.Customer;
import br.com.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private final CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") Long customerId, Model model) {
		Customer customer = customerService.find(customerId);
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") Long customerId) {
		customerService.delete(customerId);
		return "redirect:/customer/list";
	}

    @GetMapping("/search")
    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // search customers from the service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
                
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";        
    }
}
