package com.senla.sobol.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
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

	public void delete(IOrder t) {
		Savepoint savepoint = null;
		try {
			connection.setAutoCommit(false);
			savepoint = connection.setSavepoint();
			orderdao.deleteOrder(connection, t.getIdOrder());
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

	public IOrder getOrderId(Integer id) {
		IOrder order=orderdao.getOrderById(connection, id);
		return order;
	}

	public List<IOrder> getAll(String date) {
		List<IOrder> listorder = orderdao.getReadAllTable(connection, date);
		return listorder;
	}

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String date) {
		List<IOrder> listorder = orderdao.getOrderByDateAndId(connection, idcustomer, date);
		return listorder;
	}
}
