package br.com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springdemo.dao.CustomerDAO;
import br.com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerDAO customerDAO;
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return this.customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		this.customerDAO.save(customer);
	}

	@Override
	@Transactional
	public Customer find(Long customerId) {
		return this.customerDAO.find(customerId);
	}

	@Override
	@Transactional
	public void delete(Long customerId) {
		this.customerDAO.delete(customerId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return this.customerDAO.searchCustomers(theSearchName);
	}
}
