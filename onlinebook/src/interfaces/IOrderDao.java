package interfaces;

import java.text.ParseException;
import java.util.List;

import model.Order;

public interface IOrderDao {
	public List<Order> getListOrder();

	public void deleteOrder(String name);

	public void addOrder(Order order);

	public Order searchOrderById(String number);

	public Order searchOrder(String name);

	public int searchOrderIndex(String name);

	public List<Order> listorderclock(String date1, String date2) throws ParseException;

	public void updateOrder(Order order, Order order2);

	public void setListorder(List<Order> listorder);
}
