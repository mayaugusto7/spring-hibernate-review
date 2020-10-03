package br.com.springdemo.service;

import java.util.List;

import br.com.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void save(Customer customer);

	public Customer find(Long customerId);

	public void delete(Long customerId);

	public List<Customer> searchCustomers(String theSearchName);
}
