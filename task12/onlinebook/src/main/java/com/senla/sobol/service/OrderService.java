package com.senla.sobol.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.senla.sobol.controller.DBConnector;
import com.senla.sobol.dao.BookDao;
import com.senla.sobol.dao.OrderDao;
import com.senla.sobol.interfaces.IOrderService;
import com.senla.sobol.model.Orders;

public class OrderService implements IOrderService {
	private OrderDao orderdao;
	private SessionFactory sessionfactory;
	private BookDao bookdao;
	private Logger log = Logger.getLogger(OrderService.class.getName());

	public OrderService() {
		super();
		this.orderdao = new OrderDao();
		this.sessionfactory = DBConnector.getInstance().getConnection();
		this.bookdao = new BookDao();
	}

	public void delete(Orders t) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			orderdao.deleteOrder(session, t);
			bookdao.updateBook(session, t.getBook());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void update(Orders t) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			orderdao.updateOrder(session, t);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public void add(Orders t) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			orderdao.addNewOrder(session, t);
			bookdao.updateBook(session, t.getBook());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

	public Orders getOrderId(Integer id) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			Orders order = orderdao.getOrderById(session, id);
			session.getTransaction().commit();
			return order;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;

	}

	public List<Orders> getAll(String date) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			List<Orders> listorder = orderdao.getReadAllTable(session, date);
			session.getTransaction().commit();
			return listorder;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}

	public List<Orders> getOrderByDateAndId(Integer idcustomer) {
		Session session = null;
		try {
			session = sessionfactory.openSession();
			session.beginTransaction();
			List<Orders> listorder = orderdao.getOrderByDateAndId(session, idcustomer);
			session.getTransaction().commit();
			return listorder;
		} catch (HibernateException e) {
			log.error(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return null;
	}
}
