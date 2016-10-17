package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import dao.OrderDao;
import model.Book;
import model.Order;

public class OrderService {
	private static final String FINISH_ORDER = "finish order";
	private static final String NO_ORDERS_IN_SYSTEM = "ТАКОГО_ЗАКАЗА_В_СИСТЕМЕ_НЕТ";
	private static final String NO_ORDER = "Такая книга уже заказана, больше на складе нет";
	private static final String MESSAGE1 = "there is Stock";
	private static final String MESSAGE2 = "sales";
	private OrderDao orderdao;
	private List<Order> listorder;
	private List<Book> listbook;

	public OrderService(OrderDao orderdao, List<Book> listbook) {
		this.orderdao = orderdao;
		this.listorder = orderdao.getListOrder();
		this.listbook = listbook;
	}

	private Book searchBook(String name) {

		for (Book book : listbook) {
			if (book.getName().equals(name)) {
				return book;
			}

		}

		return null;

	}

	public void closeOrder(String lastname, String firstname) {
		Date date = new Date();
		for (Order order : listorder) {
			if (order.getLastname().equals(lastname) && order.getFirstname().equals(firstname)) {
				order.setDateFinishOrder(date);
				order.setStage(FINISH_ORDER);

			}
		}
	}

	public void createNewOrder(String lastname, String firstname, String nameBook) throws ParseException {
		Date date = new Date();
		Random random = new Random();
		int number = random.nextInt(1000);
		Book book = searchBook(nameBook);
		if (book != null && book.getStage().equals(MESSAGE1)) {
			Order order = new Order(number, lastname, firstname, book.getName(), book.getPrice(), date);
			book.setStage(MESSAGE2);
			addOrder(order);

		} else {
			System.out.println(NO_ORDER);
		}

	}

	public List<Order> getListOrderClock(String date1, String date2) throws ParseException {
		if (orderdao.listorderclock(date1, date2) != null) {
			List<Order> listorderClock = orderdao.listorderclock(date1, date2);
			return listorderClock;
		}
		return null;
	}

	private void addOrder(Order order) {
		this.listorder.add(order);
	}

	public void deleteOrder(String nameorder) {
		if (orderdao.searchOrderIndex(nameorder) != listorder.size()) {
			String sales = orderdao.searchOrder(nameorder).getNameBook();
			Book book = searchBook(sales);
			book.setStage(MESSAGE1);
			this.listorder.remove(orderdao.searchOrder(nameorder));
		} else {
			System.out.println(NO_ORDERS_IN_SYSTEM);
		}

	}

	
}
