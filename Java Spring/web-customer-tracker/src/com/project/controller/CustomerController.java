package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.dao.CustomerDAO;
import com.project.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the DAO
		List<Customer> customers = customerDAO.getCustomer();
		
		// add the customers to the model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
