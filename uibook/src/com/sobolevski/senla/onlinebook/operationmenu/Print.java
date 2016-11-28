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
	private String printInfoBook(Object book) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(((Book) book).getName());
		stringbuilder.append(WRITER2);
		stringbuilder.append(((Book) book).getWriter());
		stringbuilder.append(PRICE_BOOK);
		stringbuilder.append(((Book) book).getPrice());
		stringbuilder.append(YEAR_OF_PUBLISHING);
		stringbuilder.append(((Book) book).getQuantityPages());
		stringbuilder.append(STAGE2);
		stringbuilder.append(((Book) book).getStage());
		return stringbuilder.toString();
	}

	/**
	 * print information orders
	 * 
	 * @param order
	 * @return
	 */
	private String printInfoOrderOll(Object order) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(CUSTOMER_LASTNAME_ORDER);
		stringbuilder.append(((Order) order).getLastname());
		stringbuilder.append(CUSTOMER_FIRSTNAME_ORDER);
		stringbuilder.append(((Order) order).getFirstname());
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(((Order) order).getBook().getName());
		stringbuilder.append(PRICE2);
		stringbuilder.append(((Order) order).getPrice());
		stringbuilder.append(DATE_ORDER);
		stringbuilder.append(simpledate.format(((Order) order).getDate()));
		stringbuilder.append(DATE_FINISH_ORDER);
		stringbuilder.append(simpledate.format(((Order) order).getDateFinishOrder()));
		stringbuilder.append(ORDER_STAGE);
		stringbuilder.append(((Order) order).getStage());
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

	public void printListOrder(List<?> list) {
		for (Object order : list) {
			System.out.println(printInfoOrderOll(order));
		}
	}

	public void printListBook(List<?> list) {
		for (Object book : list) {
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

	public void quantityOrder(String message) {
		System.out.println(message );
	}
   
}
