package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.Customer;

public interface ICustomerService {
	public Customer getCustomer(Integer idcustomer);

	public void delete(Customer id);

	public void update(Customer t);

	public void add(Customer t);

	public List<Customer> getAll(String date);
}
