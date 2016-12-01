package service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.senla.sobol.model.IBook;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.StageBook;

import interfaces.IBookService;
import interfaces.IOrderDao;
import interfaces.IOrderService;
import model.Order;



public class OrderService implements IOrderService {
	private IOrderDao orderdao;
	private IBookService bookservice;

	public OrderService() {

	}

	public OrderService(IOrderDao orderdao, IBookService bookservice) {
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
		for (IOrder order : orderdao.getListOrder()) {
			if (order.getLastname().equals(lastname) && order.getFirstname().equals(firstname)) {
				order.setDateFinishOrder(date);
				order.setStage(StageBook.FINISH_ORDER);
			}
		}
	}
	public void setOrderdao(IOrderDao orderdao) {
		this.orderdao = orderdao;
	}

	public void setBookservice(IBookService bookservice) {
		this.bookservice = bookservice;
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
		IBook book = bookservice.searchBook(nameBook);
		if (book != null && book.getStage().equals(StageBook.THERE_IS_STOCK)) {
			IOrder order = new Order(number, lastname, firstname, book, date);
			orderdao.addOrder(order);
			book.setOrder(order);
			book.setStage(StageBook.SALES);
			book.setId(number);
			return true;
		}
		return false;
	}

	public void addCloneOrder(IOrder order) {
		orderdao.addOrder(order);
	}

	public List<IOrder> getListOrderClock(String date1, String date2) throws ParseException {
		if (orderdao.listorderclock(date1, date2) != null) {
			List<IOrder> listorderClock = orderdao.listorderclock(date1, date2);
			return listorderClock;
		}
		return null;
	}

	public List<IOrder> getListOrder() {
		List<IOrder> listorder = orderdao.getListOrder();
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
			IBook book = bookservice.searchBook(sales);
			book.setStage(StageBook.THERE_IS_STOCK);
			book.setId("");
			orderdao.deleteOrder(nameorder);
			return true;
		}
		return false;
	}

	public IOrder searchOrder(String name) {
		IOrder order = orderdao.searchOrder(name);
		return order;
	}

	public void updateOrder(IOrder order, IOrder order2) {
		orderdao.updateOrder(order, order2);

	}

	public IOrder searchOrderById(String number) {
		IOrder order = orderdao.searchOrderById(number);
		return order;
	}

}
