package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Order;

public class OrderDao {
	private List<Order> listorder;

	public OrderDao(List<Order> listorder) {
		this.listorder = listorder;
	}

	public List<Order> getListOrder() {
		return listorder;
	}

	public Order searchOrder(String name) {

		for (Order order : listorder) {
			if (order.getLastname().equals(name)) {
				return order;

			}

		}
		return null;

	}

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
}
