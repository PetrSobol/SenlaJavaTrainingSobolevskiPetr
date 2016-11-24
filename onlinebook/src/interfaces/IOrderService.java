package interfaces;

import java.text.ParseException;
import java.util.List;

import model.Order;

public interface IOrderService {
	public void closeOrder(String lastname, String firstname);

	public Boolean createNewOrder(String lastname, String firstname, String nameBook) throws ParseException;

	public void addCloneOrder(Order order);

	public List<Order> getListOrderClock(String date1, String date2) throws ParseException;

	public List<Order> getListOrder();

	public Boolean deleteOrder(String nameorder);

	public Order searchOrder(String name);

	public void updateOrder(Order order, Order order2);

	public Order searchOrderById(String number);

	public void setOrderdao(IOrderDao orderdao);

	public void setBookservice(IBookService bookservice);
}
