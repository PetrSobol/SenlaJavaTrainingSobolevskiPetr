package service;

import java.util.Date;
import java.util.List;

import com.senla.sobol.model.IOrder;

import interfaces.IOrderDao;
import interfaces.IOrderService;

public class OrderService implements IOrderService {
	private IOrderDao orderdao;

	public OrderService() {
		super();
	}

	public Boolean searchIdBook(Integer idbook) {
		List<IOrder> listorder = getAll();

		for (IOrder order : listorder) {
			if (order.getBook().getIdBook().equals(idbook)) {
				return true;
			}

		}
		return false;
	}

	public OrderService(IOrderDao orderdao) {
		super();
		this.orderdao = orderdao;
	}

	@Override
	public void delete(IOrder t) {
		orderdao.delete(t);

	}

	@Override
	public void update(IOrder t) {
		orderdao.update(t);

	}

	@Override
	public void add(IOrder t) {
		orderdao.addNew(t);

	}

	public void setOrderdao(IOrderDao orderdao) {
		this.orderdao = orderdao;
	}

	public IOrder getOrder(Integer idcustomer, Integer idbook, Date date) {
		List<IOrder> listorder = orderdao.getReadAllTable();
		for (IOrder order : listorder) {
			if (idcustomer.equals(order.getCustomer().getIdCustomer()) && idbook.equals(order.getBook().getIdBook())
					&& date.equals(order.getDateOrder())) {
				return order;
			}

		}
		return null;
	}

	@Override
	public List<IOrder> getAll() {
		List<IOrder> listorder = orderdao.getReadAllTable();
		return listorder;
	}

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String date) {
		List<IOrder> listorder = orderdao.getOrderByDateAndId(idcustomer, date);
		return listorder;
	}
}
