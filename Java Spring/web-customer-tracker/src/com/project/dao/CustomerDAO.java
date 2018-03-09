package com.project.dao;

import java.util.List;

import com.project.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomer();

	public void saveCustomer(Customer theCustomer);
}
