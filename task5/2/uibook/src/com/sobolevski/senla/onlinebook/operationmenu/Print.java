package com.sobolevski.senla.onlinebook.operationmenu;

import java.text.SimpleDateFormat;
import java.util.List;

import com.sobolevski.senla.onlinebook.menu.IMenu;

import model.Book;
import model.Order;

public class Print {
	private static final String NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL = "Number of completed orders in the time interval   ";
	private static final String THE_COMPANY_EARNED_MONEY = "The company earned money -";
	private static final String DATE_TWO_DD_MM_YYYY = "Date two? (dd.MM.yyyy)";
	private static final String DATE_ONE_DD_MM_YYYY = "Date one? (dd.MM.yyyy)";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YEAR_YYYY = "Year? #yyyy#";
	private static final String PRICE = "Price?";
	private static final String WRITER_BOOK = "Writer book?";
	private static final String NAME_BOOK2 = "Name book?";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String OPERATION_FINISH_SUCESS = "Operation finish sucess";
	private static final String STAGE2 = "  Stage: ";
	private static final String YEAR_OF_PUBLISHING = "  Year of publishing: ";
	private static final String PRICE_BOOK = "  Price book: ";
	private static final String WRITER2 = "  Writer: ";
	private static final String NAME_BOOK = " Name book: ";
	private static final String ORDER_STAGE = " Order stage: ";
	private static final String DATE_FINISH_ORDER = " Date finish order: ";
	private static final String DATE_ORDER = " Date order: ";
	private static final String PRICE2 = " Price: ";
	private static final String CUSTOMER_FIRSTNAME_ORDER = " Customer firstname order ";
	private static final String CUSTOMER_LASTNAME_ORDER = " Customer lastname order: ";
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	private String printInfoBook(Book book) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(book.getName());
		stringbuilder.append(WRITER2);
		stringbuilder.append(book.getWriter());
		stringbuilder.append(PRICE_BOOK);
		stringbuilder.append(book.getPrice());
		stringbuilder.append(YEAR_OF_PUBLISHING);
		stringbuilder.append(book.getQuantityPages());
		stringbuilder.append(STAGE2);
		stringbuilder.append(book.getStage());
		return stringbuilder.toString();
	}

	private String printInfoOrderOll(Order order) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(CUSTOMER_LASTNAME_ORDER);
		stringbuilder.append(order.getLastname());
		stringbuilder.append(CUSTOMER_FIRSTNAME_ORDER);
		stringbuilder.append(order.getFirstname());
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(order.getBook().getName());
		stringbuilder.append(PRICE2);
		stringbuilder.append(order.getPrice());
		stringbuilder.append(DATE_ORDER);
		stringbuilder.append(simpledate.format(order.getDate()));
		stringbuilder.append(DATE_FINISH_ORDER);
		stringbuilder.append(simpledate.format(order.getDateFinishOrder()));
		stringbuilder.append(ORDER_STAGE);
		stringbuilder.append(order.getStage());
		return stringbuilder.toString();
	}

	public void printMenu(List<IMenu> listmenu) {
		for (IMenu menu : listmenu) {
			System.out.println(menu.getId() + ": " + menu.getTitle());
		}

	}

	public void printListOrder(List<Order> listorder) {
		for (Order order : listorder) {
			System.out.println(printInfoOrderOll(order));
		}
	}

	public void printListBook(List<Book> listbook) {
		for (Book book : listbook) {
			System.out.println(printInfoBook(book));
		}
	}

	public void printFinishOperation() {
		System.out.println(OPERATION_FINISH_SUCESS);
	}

	public void printNoFinishOperation() {
		System.out.println(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
	}

	public void addbookName() {
		System.out.println(NAME_BOOK2);
	}

	public void addbookWriter() {
		System.out.println(WRITER_BOOK);
	}

	public void addbookPrice() {
		System.out.println(PRICE);
	}

	public void addbookYear() {
		System.out.println(YEAR_YYYY);
	}

	public void addOrderLastname() {
		System.out.println(YOUR_LASTNAME);
	}

	public void addOrderFirstName() {
		System.out.println(YOUR_FIRSTNAME);
	}

	public void dateOne() {
		System.out.println(DATE_ONE_DD_MM_YYYY);
	}

	public void dateTwo() {
		System.out.println(DATE_TWO_DD_MM_YYYY);
	}

	public void dateFinish(Integer i) {
		System.out.println(THE_COMPANY_EARNED_MONEY+i);
	}
	public void quantityOrder(Integer i){
		System.out.println(NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL+i);
	}
}
