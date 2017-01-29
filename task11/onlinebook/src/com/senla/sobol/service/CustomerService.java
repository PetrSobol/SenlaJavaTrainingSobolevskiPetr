package com.senla.sobol.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.CustomerDao;
import com.senla.sobol.interfaces.ICustomerService;
import com.senla.sobol.model.ICustomer;

public class CustomerService implements ICustomerService {
	private CustomerDao customerdao;
	private static Logger log = Logger.getLogger(CustomerService.class.getName());
	private Connection connection;

	public CustomerService() {
		super();
		this.customerdao = new CustomerDao();
		try {
			this.connection = DBConnector.getInstance().getConnection();
		} catch (SQLException e) {
			log.error(e);
		}
	}

	public void delete(Integer id) {
		customerdao.deleteCustomer(connection, id);

	}

	public void update(ICustomer t) {
		customerdao.updateCustomer(connection, t);

	}

	public void add(ICustomer t) {
		try {
			customerdao.addNewCustomer(connection, t);
		} catch (SQLException e) {
			log.error(e);
		}

	}

	public List<ICustomer> getAll(String date) {

		List<ICustomer> listcustomer = customerdao.getReadAllTable(connection, date);

		return listcustomer;
	}

	public ICustomer getCustomer(Integer idcustomer) {
		ICustomer customer = customerdao.getIDCustomer(connection, idcustomer);
		return customer;
	}
}
