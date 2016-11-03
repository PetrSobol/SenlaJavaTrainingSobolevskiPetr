package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import dao.BookDao;
import dao.OrderDao;
import model.Book;
import model.Order;
import service.BookService;
import service.OrderService;
import sort.SortBookDate;
import sort.SortBookName;
import sort.SortBookPrice;
import sort.SortBookStock;
import sort.SortDateOrder;
import sort.SortPriceOrder;
import sort.SortStageOrder;

public class OnlineBook {
	private static OnlineBook onlinebook;
	private BookService bookService;
	private OrderService orderservice;
	private static Logger log = Logger.getLogger(OnlineBook.class.getName());

	private OnlineBook() throws ParseException {
		BookDao bookdao = new BookDao(getReadFileBook());
		OrderDao orderdao = new OrderDao(getReadFileOrder());
		this.bookService = new BookService(bookdao);
		this.orderservice = new OrderService(orderdao, this.bookService);

	}

	public static OnlineBook getInstance() {
		if (onlinebook == null) {
			try {
				onlinebook = new OnlineBook();
			} catch (ParseException e) {
				log.error(e);
			}
		}
		return onlinebook;
	}

	// return true if order add succes
	public Boolean addOrder(String lastname, String firstname, String namebook) throws ParseException {
		if (orderservice.createNewOrder(lastname, firstname, namebook)) {
			return true;
		}
		return false;

	}

	private List<Book> getReadFileBook() {
		List<Book> listbook;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getRoatProperty("book")))) {
			listbook = (ArrayList<Book>) ois.readObject();
			return listbook;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	private List<Order> getReadFileOrder() {
		List<Order> listorder;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(getRoatProperty("order")))) {
			listorder = (ArrayList<Order>) ois.readObject();
			return listorder;
		} catch (Exception e) {
			log.error(e);
		}
		return null;
	}

	// add new book to databases
	public void addNewBook(String name, String writer, Integer price, Integer quantity) {
		bookService.addBook(new Book(name, writer, price, quantity));
	}

	// close order in databases
	public void closeOrder(String lastname, String firstname) {
		orderservice.closeOrder(lastname, firstname);
	}

	// delete book in databases
	public void deleteBook(String name) {
		bookService.deleteBook(name);
	}

	// return true if delete order sucess
	public Boolean deleteOrder(String name) {
		if (orderservice.deleteOrder(name)) {
			return true;
		}

		return false;

	}

	// sort list books by name
	public List<Book> sortBookName() {
		List<Book> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookName());
		return listbook;
	}

	// sort list books by price
	public List<Book> sortBookPrice() {
		List<Book> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookPrice());
		return listbook;

	}

	// sort list books by dates
	public List<Book> sortBookDate() {
		List<Book> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookDate());
		return listbook;

	}

	/// sort list books by where is the stock
	public List<Book> sortBookStage() {
		List<Book> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookStock());
		return listbook;
	}

	public List<Order> sortOrderDate() {
		List<Order> listbook = orderservice.getListOrder();
		Collections.sort(listbook, new SortDateOrder());
		return listbook;
	}

	public List<Order> sortOrderPrice() {
		List<Order> listbook = orderservice.getListOrder();
		Collections.sort(listbook, new SortPriceOrder());
		return listbook;
	}

	public List<Order> sortOrderStage() {
		List<Order> listbook = orderservice.getListOrder();
		Collections.sort(listbook, new SortStageOrder());
		return listbook;
	}

	// save changes in databases
	public void saveToDataBases() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getRoatProperty("book")))) {
			oos.writeObject(getListBookAll());
		} catch (Exception e) {
			log.error(e);
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getRoatProperty("order")))) {
			oos.writeObject(getListOrderAll());
		} catch (Exception e) {
			log.error(e);
		}
	}

	public List<Order> sortOrderDateToDate(String date1, String date2) throws ParseException {
		List<Order> listorder = orderservice.getListOrderClock(date1, date2);
		Collections.sort(listorder, new SortDateOrder());
		return listorder;
	}

	public List<Order> sortOrderDateToPrice(String date1, String date2) throws ParseException {
		List<Order> listorder = orderservice.getListOrderClock(date1, date2);
		Collections.sort(listorder, new SortPriceOrder());
		return listorder;
	}

	public Integer printOrderPriceToOrder(String date1, String date2) throws ParseException {
		List<Order> listorder = orderservice.getListOrderClock(date1, date2);
		Integer priceOll = 0;
		for (Order order : listorder) {
			priceOll += order.getPrice();
		}

		return priceOll;
	}

	public Integer printOrderFinish(String date1, String date2) throws ParseException {
		List<Order> listorder = orderservice.getListOrderClock(date1, date2);
		Integer orderOll = 0;
		for (Order order : listorder) {
			orderOll++;
		}

		return orderOll;
	}

	public List<Order> getListOrderAll() {
		List<Order> listorder = orderservice.getListOrder();
		return listorder;
	}

	public List<Book> getListBookAll() {
		List<Book> listbook = bookService.getListBook();
		return listbook;
	}

	private String getRoatProperty(String name) {
		String roat = null;
		FileInputStream file;
		Properties property = new Properties();
		try {
			file = new FileInputStream("resources/roat.properties");

			property.load(file);
			if(name.equals("book")){
				roat = property.getProperty("dbbook");
			}else{
				roat = property.getProperty("dborder");
			}
			
		} catch (FileNotFoundException e) {
			log.error(e);
		} catch (IOException e) {
			log.error(e);
		}
		return roat;
	}

}
