package service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import dao.OrderDao;
import model.Book;
import model.Order;
import model.StageBook;

public class OrderService {
	private OrderDao orderdao;
	private BookService bookservice;

	public OrderService(OrderDao orderdao, BookService bookservice) {
		this.orderdao = orderdao;
		this.bookservice = bookservice;
	}

	/**
	 * close order to databases
	 * 
	 * @param lastname
	 * @param firstname
	 */

	public void closeOrder(String lastname, String firstname) {
		Date date = new Date();
		for (Order order : orderdao.getListOrder()) {
			if (order.getLastname().equals(lastname) && order.getFirstname().equals(firstname)) {
				order.setDateFinishOrder(date);
				order.setStage(StageBook.FINISH_ORDER);
			}
		}
	}

	/**
	 * return true if order there is no to databases
	 * 
	 * @param lastname
	 * @param firstname
	 * @param nameBook
	 * @return
	 * @throws ParseException
	 */
	public Boolean createNewOrder(String lastname, String firstname, String nameBook) throws ParseException {
		Date date = new Date();
		String number = UUID.randomUUID().toString();
		Book book = bookservice.searchBook(nameBook);
		if (book != null && book.getStage().equals(StageBook.THERE_IS_STOCK)) {
			Order order = new Order(number, lastname, firstname, book, date);
			orderdao.addOrder(order);
			book.setOrder(order);
			book.setStage(StageBook.SALES);
			book.setId(number);
			return true;
		}
		return false;
	}

	public void addCloneOrder(Order order) {
		orderdao.addOrder(order);
	}

	public List<Order> getListOrderClock(String date1, String date2) throws ParseException {
		if (orderdao.listorderclock(date1, date2) != null) {
			List<Order> listorderClock = orderdao.listorderclock(date1, date2);
			return listorderClock;
		}
		return null;
	}

	public List<Order> getListOrder() {
		List<Order> listorder = orderdao.getListOrder();
		return listorder;
	}

	/**
	 * return true if book there is yes to databases
	 * 
	 * @param nameorder
	 * @return
	 */
	public Boolean deleteOrder(String nameorder) {
		if (orderdao.searchOrderIndex(nameorder) != orderdao.getListOrder().size()) {
			String sales = orderdao.searchOrder(nameorder).getBook().getName();
			Book book = bookservice.searchBook(sales);
			book.setStage(StageBook.THERE_IS_STOCK);
			book.setId("");
			orderdao.deleteOrder(nameorder);
			return true;
		}
		return false;
	}

	public Order searchOrder(String name) {
		Order order = orderdao.searchOrder(name);
		return order;
	}

	public void updateOrder(Order order, Order order2) {
		orderdao.updateOrder(order, order2);

	}

	public Order searchOrderById(String number) {
		Order order = orderdao.searchOrderById(number);
		return order;
	}

}
