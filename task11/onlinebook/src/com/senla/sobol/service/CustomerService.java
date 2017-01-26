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
		customerdao.delete(connection,id);

	}

	public void update(ICustomer t) {
		customerdao.update(connection,t);

	}

	public void add(ICustomer t) {
		customerdao.addNew(connection,t);

	}

	public List<ICustomer> getAll(String date) {
		List<ICustomer> listcustomer=null;
		if(date!=null){
			listcustomer = customerdao.getReadAllTable(connection,date);
		}else{
			 listcustomer = customerdao.getReadAllTable(connection,null);
		}
		return listcustomer;
	}

	public ICustomer getCustomer(Integer idcustomer) {
		ICustomer customer = customerdao.getCustomer(connection,idcustomer);
		return customer;
	}

}