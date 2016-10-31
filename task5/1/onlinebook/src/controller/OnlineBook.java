package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.BookDao;
import dao.OrderDao;
import model.Book;
import model.Order;
import model.PrintInformationModel;
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
	private DataBases dataBases = new DataBases();
	private Converter converter = new Converter();
	private PrintInformationModel printinformation = new PrintInformationModel();
	private BookService bookService;
	private OrderService orderservice;

	public OnlineBook() throws ParseException {
		BookDao bookdao = new BookDao(converter.getListBook(new ArrayList<Book>(), dataBases.readFileDB()));
		OrderDao orderdao = new OrderDao(converter.getListOrder(new ArrayList<Order>(), dataBases.readFileDB()));
		this.bookService = new BookService(bookdao);
		this.orderservice = new OrderService(orderdao, this.bookService);
	}

	// return true if order add succes
	public Boolean addOrder(String lastname, String firstname, String namebook) throws ParseException {
		if (orderservice.createNewOrder(lastname, firstname, namebook)) {
			return true;
		}
		return false;

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
		dataBases.writeFileDB(converter.getOllArray(orderservice.getListOrder(), bookService.getListBook()));
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

	public Integer  printOrderFinish(String date1, String date2) throws ParseException {
		List<Order> listorder = orderservice.getListOrderClock(date1, date2);
		Integer orderOll = 0;
		for (Order order : listorder) {
			orderOll++;
		}

		return orderOll;
	}

	public void printListOrder(List<Order> listorder) {
		for (Order order : listorder) {
			System.out.println(printinformation.printInfoOrderOll(order));
		}
	}

	public void printListBook(List<Book> listbook) {
		for (Book book : listbook) {
			System.out.println(printinformation.printInfoBook(book));
		}
	}

	public void printOrderAll() {
		if (orderservice.getListOrder() != null) {
			for (Order order : orderservice.getListOrder()) {
				System.out.println(printinformation.printInfoOrderOll(order));
			}
		}
	}

	public void printBookAll() {
		if (bookService.getListBook() != null) {
			for (Book boks : bookService.getListBook()) {
				System.out.println(printinformation.printInfoBook(boks));
			}
		}

	}

}
