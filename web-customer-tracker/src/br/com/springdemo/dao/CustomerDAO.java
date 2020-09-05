package br.com.springdemo.dao;

import java.util.List;

import br.com.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
}
