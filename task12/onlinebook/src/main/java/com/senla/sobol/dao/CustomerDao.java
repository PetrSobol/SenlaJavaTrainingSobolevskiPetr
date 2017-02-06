package com.senla.sobol.dao;

import java.util.List;

import org.hibernate.Session;

import com.senla.sobol.interfaces.ACommonDAO;
import com.senla.sobol.model.Customer;

public class CustomerDao extends ACommonDAO<Customer> {
	public CustomerDao() {
		super(Customer.class);
	}

	public void addNewCustomer(Session session, Customer t) {
		addNew(session, t);
	}

	public List<Customer> getReadAllTable(Session session, String date) {
		List<Customer> listcustomer = getAll(session,date);
		return listcustomer;
	}

	public void deleteCustomer(Session session, Customer idcustomer) {
		delete(session, idcustomer);
	}

	public void updateCustomer(Session session, Customer t) {
		update(session, t);
	}

	public Customer getIDCustomer(Session session, Integer id) {
		Customer customer = getID(session, id);
		return customer;
	}
}
