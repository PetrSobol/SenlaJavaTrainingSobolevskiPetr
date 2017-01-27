package com.senla.sobol.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.BookDao;
import com.senla.sobol.dao.OrderDao;
import com.senla.sobol.interfaces.IOrderService;
import com.senla.sobol.model.IOrder;

public class OrderService implements IOrderService {
	private OrderDao orderdao;
	private BookDao bookdao;
	private Connection connection;
	private static Logger log = Logger.getLogger(OrderService.class.getName());

	public OrderService() {
		super();

		try {
			this.orderdao = new OrderDao();
			this.bookdao = new BookDao();
			this.connection = DBConnector.getInstance().getConnection();
		} catch (SQLException e) {
			log.error(e);
		}
	}

	public Boolean searchIdBook(Integer idbook) {
		List<IOrder> listorder = getAll(null);
		for (IOrder order : listorder) {
			if (order.getBook().getIdBook().equals(idbook)) {
				return true;
			}
		}
		return false;
	}

	public void delete(IOrder t) {
		Savepoint savepoint = null;
		try {
			connection.setAutoCommit(false);
			savepoint = connection.setSavepoint();
			orderdao.deleteOrder(connection, t);
			bookdao.updateBook(connection, t.getBook());
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
				log.error(e);
			}
			log.error(e);
		}

	}

	public void update(IOrder t) {
		orderdao.updateOrder(connection, t);
	}

	public void add(IOrder t) {
		Savepoint savepoint = null;
		try {
			connection.setAutoCommit(false);
			savepoint = connection.setSavepoint();
			orderdao.addNewOrder(connection, t);
			bookdao.updateBook(connection, t.getBook());
			connection.commit();
			connection.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
				log.error(e);
			}
			log.error(e);
		}

	}

	public IOrder getOrder(Integer idcustomer, Integer idbook, Date date) {
		List<IOrder> listorder = orderdao.getReadAllTable(connection,null);
		for (IOrder order : listorder) {
			if (idcustomer.equals(order.getCustomer().getIdCustomer()) && idbook.equals(order.getBook().getIdBook())
					&& date.equals(order.getDateOrder())) {
				return order;
			}
		}
		return null;
	}

	public List<IOrder> getAll(String date) {
		List<IOrder> listorder=null;
		if(date!=null){
			listorder = orderdao.getReadAllTable(connection,date);
		}else{
			listorder = orderdao.getReadAllTable(connection,null);
		}
		 
		return listorder;
	}

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String date) {
		List<IOrder> listorder = orderdao.getOrderByDateAndId(connection, idcustomer, date);
		return listorder;
	}
}
