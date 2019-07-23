package com.mrinmoy.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrinmoy.springdemo.dao.CustomerDAO;
import com.mrinmoy.springdemo.entity.Customer;

@Service
public class CustomerServiceImport implements CustomerService {

	//need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomer();
	}

	@Override
	@Transactional 
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {


		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);
		
	}

}
