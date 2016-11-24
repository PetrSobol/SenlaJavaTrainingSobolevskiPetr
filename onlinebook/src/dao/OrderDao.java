package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interfaces.IOrderDao;
import model.Order;

public class OrderDao implements IOrderDao {
	private List<Order> listorder;

	public OrderDao() {

	}

	public OrderDao(List<Order> listorder) {
		this.listorder = listorder;
	}

	public List<Order> getListOrder() {
		return listorder;
	}

	
	public void setListorder(List<Order> listorder) {
		this.listorder = listorder;
	}

	public void deleteOrder(String name) {
		this.listorder.remove(searchOrder(name));
	}

	public void addOrder(Order order) {
		this.listorder.add(order);
	}

	public Order searchOrderById(String number) {
		for (Order order : listorder) {
			if (order.getIdNumberOrder().equals(number)) {
				return order;
			}
		}
		return null;
	}

	/**
	 * search order by name and return order
	 * 
	 * @param name
	 * @return
	 */
	public Order searchOrder(String name) {

		for (Order order : listorder) {
			if (order.getLastname().equals(name)) {
				return order;
			}
		}
		return null;
	}

	/**
	 * search order by index and return index order
	 * 
	 * @param name
	 * @return
	 */
	public int searchOrderIndex(String name) {
		int number = 0;
		for (Order order : listorder) {
			if (order.getLastname().equals(name)) {

				return number;

			}
			number++;
		}
		return number;
	}

	/**
	 * search list orders in range date
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public List<Order> listorderclock(String date1, String date2) throws ParseException {
		SimpleDateFormat simple = new SimpleDateFormat("dd.MM.yyyy");
		List<Order> listorderclock = new ArrayList<Order>();
		Date datemin = simple.parse(date1);
		Date datemax = simple.parse(date2);
		for (Order order : listorder) {
			if (order.dateFinishOrder().after(datemin) && order.dateFinishOrder().before(datemax)) {
				listorderclock.add(order);
			}
		}
		return listorderclock;
	}

	public void updateOrder(Order order, Order order2) {
		if (order2 != null) {
			order2.setLastname(order.getLastname());
			order2.setFirstname(order.getFirstname());
			order2.setBook(order.getBook());
			order2.setPrice(order.getPrice());
			order2.setDate(order.getDate());
			order2.setDateFinishOrder(order.getDateFinishOrder());
			order2.setStage(order.getStage());
		}
	}

}
