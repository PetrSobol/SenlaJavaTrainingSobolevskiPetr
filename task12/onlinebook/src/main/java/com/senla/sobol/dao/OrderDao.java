package com.senla.sobol.dao;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.senla.sobol.interfaces.ACommonDAO;
import com.senla.sobol.model.Orders;

public class OrderDao extends ACommonDAO<Orders> {
	private Logger log = Logger.getLogger(OrderDao.class.getName());

	public OrderDao() {
		super(Orders.class);
	}

	public void addNewOrder(Session session, Orders t) {
		addNew(session, t);
	}

	public Orders getOrderById(Session session, Integer idOrder) {
		Orders order = getID(session, idOrder);
		Hibernate.initialize(order.getBook());
		Hibernate.initialize(order.getCustomer());
		return order;
	}

	public List<Orders> getReadAllTable(Session session, String date) {
		List<Orders> listorder = getAll(session, date);
		for (Orders orders : listorder) {
			Hibernate.initialize(orders.getBook());
			Hibernate.initialize(orders.getCustomer());
		}
		return listorder;

	}

	public void deleteOrder(Session session, Orders orders) {
		delete(session, orders);
	}

	public void updateOrder(Session session, Orders t) {
		update(session, t);
	}

	public List<Orders> getOrderByDateAndId(Session session, Integer idcustomer) {
		try {

			CriteriaBuilder criteriabilder = session.getCriteriaBuilder();
			CriteriaQuery<Orders> criteriaquerry = criteriabilder.createQuery(Orders.class);
			Root<Orders> root = criteriaquerry.from(Orders.class);
			criteriaquerry.select(root);
			criteriaquerry.where(criteriabilder.equal(root.get("customer").get("idCustomer"), idcustomer));
			TypedQuery<Orders> typedquerry = session.createQuery(criteriaquerry);
			List<Orders> list = typedquerry.getResultList();
			for (Orders orders : list) {
				Hibernate.initialize(orders.getBook());
				Hibernate.initialize(orders.getCustomer());
			}

			return list;
		} catch (NoResultException e) {
			log.error(e);
		}
		return null;
	}

}
