package com.sobolevski.senla.onlinebook.operationmenu;

import java.text.SimpleDateFormat;
import java.util.List;

import com.sobolevski.senla.onlinebook.menu.IMenu;

import model.Book;
import model.Order;

public class Print {
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

	/**
	 * print information books
	 * 
	 * @param book
	 * @return
	 */
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

	/**
	 * print information orders
	 * 
	 * @param order
	 * @return
	 */
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

	/**
	 * print menu
	 * 
	 * @param listmenu
	 */
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

	/**
	 * print message
	 * 
	 * @param message
	 */
	public void printMessage(String message) {
		System.out.println(message);
	}

	public void quantityOrder(String message, Integer i) {
		System.out.println(message + i);
	}
   
}
