package com.mrinmoy.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrinmoy.springdemo.dao.CustomerDAO;
import com.mrinmoy.springdemo.entity.Customer;
import com.mrinmoy.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject customer dao
	/*@Autowired //because of new layer which is service layer
	private CustomerDAO customerDAO;*/
	
	//need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get the cusromer from dao
		List<Customer> theCustomers= customerService.getCustomers();
		//add the customers to the model
		System.out.println(theCustomers);
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer); 
		return "addcustomerform";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save customer using service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String updateCustomer(@RequestParam("customerId") int theId,Model theModel) {
		
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		//set customer as a model attribute to pre-populate form
		theModel.addAttribute("customer",theCustomer);
		//send over to our form
		return "addcustomerform";
	}
	
	@GetMapping("/delete")
	
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete the customer
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}
