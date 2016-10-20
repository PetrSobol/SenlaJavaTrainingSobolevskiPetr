package service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import dao.OrderDao;
import model.Book;
import model.Order;

public class OrderService {
	private static final String FINISH_ORDER = "finish order";
	private static final String NO_ORDERS_IN_SYSTEM = "SUCH AN ORDER IN NO";
	private static final String NO_ORDER = "This book has already ordered more stock not";
	private static final String MESSAGE1 = "there is Stock";
	private static final String MESSAGE2 = "sales";
	private OrderDao orderdao;
	private BookService bookservice;
	public OrderService(OrderDao orderdao, BookService bookservice) {
		this.orderdao = orderdao;
		this.bookservice=bookservice;
			}
	private Book searchBook(String name) {

		for (Book book : bookservice.getListBook()) {
			if (book.getName().equals(name)) {
				return book;
			}
		}
		return null;
	}

	public void closeOrder(String lastname, String firstname) {
		Date date = new Date();
		for (Order order : orderdao.getListOrder()) {
			if (order.getLastname().equals(lastname) && order.getFirstname().equals(firstname)) {
				order.setDateFinishOrder(date);
				order.setStage(FINISH_ORDER);
			}
		}
	}

	public void createNewOrder(String lastname, String firstname, String nameBook) throws ParseException {
		Date date = new Date();
		String number = UUID.randomUUID().toString();
		Book book = searchBook(nameBook);
		if (book != null && book.getStage().equals(MESSAGE1)) {
			Order order = new Order(number, lastname, firstname, book,  date);
			addOrder(order);
			book.setOrder(order);
			book.setStage(MESSAGE2);
			book.setId(number);
			
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
		orderdao.getListOrder().add(order);
	}
    public List<Order> getListOrder(){
    	List<Order> listorder=orderdao.getListOrder();
    	return listorder;
    }
	public void deleteOrder(String nameorder) {
		if (orderdao.searchOrderIndex(nameorder) != orderdao.getListOrder().size()) {
			String sales = orderdao.searchOrder(nameorder).getBook().getName();
			Book book = searchBook(sales);
			book.setStage(MESSAGE1);
			book.setId("");
			orderdao.getListOrder().remove(orderdao.searchOrder(nameorder));
		} else {
			System.out.println(NO_ORDERS_IN_SYSTEM);
		}
	}
}
