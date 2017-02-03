package com.senla.sobol.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.CustomerDao;
import com.senla.sobol.interfaces.ICustomerService;
import com.senla.sobol.model.Customer;

public class CustomerService implements ICustomerService {
	private CustomerDao customerdao;
	private SessionFactory sessionfactory;

	public CustomerService() {
		super();
		this.customerdao = new CustomerDao();
		this.sessionfactory = DBConnector.getInstance().getConnection();

	}

	public void delete(Customer customer) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		customerdao.deleteCustomer(session, customer);
		session.getTransaction().commit();
		session.close();
	}

	public void update(Customer t) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		customerdao.updateCustomer(session, t);
		session.getTransaction().commit();
		session.close();

	}

	public void add(Customer t) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		customerdao.addNewCustomer(session, t);
		session.getTransaction().commit();
		session.close();
	}

	public List<Customer> getAll(String date) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		List<Customer> listcustomer = customerdao.getReadAllTable(session, date);
		session.getTransaction().commit();
		session.close();
		return listcustomer;
	}

	public Customer getCustomer(Integer idcustomer) {
		Session session = sessionfactory.openSession();
		session.beginTransaction();
		Customer customer = customerdao.getIDCustomer(session, idcustomer);
		session.getTransaction().commit();
		session.close();
		return customer;
	}
}
