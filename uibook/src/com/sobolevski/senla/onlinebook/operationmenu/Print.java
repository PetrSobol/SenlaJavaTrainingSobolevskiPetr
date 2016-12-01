package com.sobolevski.senla.onlinebook.operationmenu;

import java.text.SimpleDateFormat;
import java.util.List;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IBook;
import com.sobolevski.senla.onlinebook.menu.IMenu;


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
		stringbuilder.append(((IBook) book).getName());
		stringbuilder.append(WRITER2);
		stringbuilder.append(((IBook) book).getWriter());
		stringbuilder.append(PRICE_BOOK);
		stringbuilder.append(((IBook) book).getPrice());
		stringbuilder.append(YEAR_OF_PUBLISHING);
		stringbuilder.append(((IBook) book).getQuantityPages());
		stringbuilder.append(STAGE2);
		stringbuilder.append(((IBook) book).getStage());
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
		stringbuilder.append(((IOrder) order).getLastname());
		stringbuilder.append(CUSTOMER_FIRSTNAME_ORDER);
		stringbuilder.append(((IOrder) order).getFirstname());
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(((IOrder) order).getBook().getName());
		stringbuilder.append(PRICE2);
		stringbuilder.append(((IOrder) order).getPrice());
		stringbuilder.append(DATE_ORDER);
		stringbuilder.append(simpledate.format(((IOrder) order).getDate()));
		stringbuilder.append(DATE_FINISH_ORDER);
		stringbuilder.append(simpledate.format(((IOrder) order).getDateFinishOrder()));
		stringbuilder.append(ORDER_STAGE);
		stringbuilder.append(((IOrder) order).getStage());
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
