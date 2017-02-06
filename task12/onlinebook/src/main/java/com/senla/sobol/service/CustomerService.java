package com.senla.sobol.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.CustomerDao;
import com.senla.sobol.interfaces.ICustomerService;
import com.senla.sobol.model.Customer;

public class CustomerService implements ICustomerService {
	private CustomerDao customerdao;
	private SessionFactory sessionfactory;
	private Logger log = Logger.getLogger(CustomerService.class.getName());

	public CustomerService() {
		super();
		this.customerdao = new CustomerDao();
		this.sessionfactory = DBConnector.getInstance().getConnection();

	}

	public void delete(Customer customer) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			customerdao.deleteCustomer(session, customer);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(Customer t) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			customerdao.updateCustomer(session, t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void add(Customer t) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			customerdao.addNewCustomer(session, t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public List<Customer> getAll(String date) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			List<Customer> listcustomer = customerdao.getReadAllTable(session, date);
			session.getTransaction().commit();
			return listcustomer;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return null;

	}

	public Customer getCustomer(Integer idcustomer) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			Customer customer = customerdao.getIDCustomer(session, idcustomer);
			session.getTransaction().commit();
			return customer;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;

	}
}
