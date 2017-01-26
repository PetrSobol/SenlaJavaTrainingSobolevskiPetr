package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.ICustomer;

public interface ICustomerService {
	public ICustomer getCustomer(Integer idcustomer);

	public void delete(Integer id);

	public void update(ICustomer t);

	public void add(ICustomer t);

	public List<ICustomer> getAll(String date);
}
