package com.sobolevski.senla.onlinebook.operationmenu;

import java.util.List;
import com.sobolevski.senla.onlinebook.menu.IMenu;
import com.senla.sobol.model.*;;
public class Print {

	private static final String DATE_ORDER = "Date order";
	private static final String PRICE_BOOK = "Price book";
	private static final String PRICE_BOOK_ONE = "Price book one";
	private static final String QUANTITY_BOOK = "Quantity book";
	private static final String NAME_BOOK = "Name book";
	private static final String ID_WRITER2 = "Id Writer";
	private static final String ID_BOOK = "ID Book";
	private static final String PHONE_CUSTOMER = "Phone customer";
	private static final String FIRSTNAME_CUSTOMER = "Firstname customer";
	private static final String LASTNAME_CUSTOMER = "Lastname customer";
	private static final String ID_CUSTOMER = "Id customer";
	private static final String DATE_DIED = "Date died";
	private static final String DATE_START = "Date start";
	private static final String FIRSTNAME_WRITER = "Firstname writer";
	private static final String LASTNAME_WRITER = "Lastname writer";
	private static final String ID_WRITER = "Id writer";

	private String printInfoWriterOll(Object writer) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(ID_WRITER);
		stringbuilder.append(((Writer) writer).getIdWriter());
		stringbuilder.append(LASTNAME_WRITER);
		stringbuilder.append(((Writer) writer).getLastname());
		stringbuilder.append(FIRSTNAME_WRITER);
		stringbuilder.append(((Writer) writer).getFirstname());
		stringbuilder.append(DATE_START);
		stringbuilder.append(((Writer) writer).getStartYear());
		stringbuilder.append(DATE_DIED);
		stringbuilder.append(((Writer) writer).getDiedYear());
		return stringbuilder.toString();
	}

	private String printInfoCustomerOll(Object customer) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(ID_CUSTOMER);
		stringbuilder.append(((Customer) customer).getIdCustomer());
		stringbuilder.append(LASTNAME_CUSTOMER);
		stringbuilder.append(((Customer) customer).getLastname());
		stringbuilder.append(FIRSTNAME_CUSTOMER);
		stringbuilder.append(((Customer) customer).getFirstname());
		stringbuilder.append(PHONE_CUSTOMER);
		stringbuilder.append(((Customer) customer).getPhone());
		return stringbuilder.toString();
	}

	/**
	 * print information books
	 * 
	 * @param book
	 * @return
	 */
	private String printInfoBook(Object book) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(ID_BOOK);
		stringbuilder.append(((Book) book).getIdBook());
		stringbuilder.append(ID_WRITER2);
		stringbuilder.append(((Book) book).getWriter().getIdWriter());
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(((Book) book).getNameBook());
		stringbuilder.append(QUANTITY_BOOK);
		stringbuilder.append(((Book) book).getQuantityPages());
		stringbuilder.append(PRICE_BOOK_ONE);
		stringbuilder.append(((Book) book).getPrice());
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
		stringbuilder.append(FIRSTNAME_CUSTOMER);
		stringbuilder.append(((Orders) order).getCustomer().getFirstname());
		stringbuilder.append(LASTNAME_CUSTOMER);
		stringbuilder.append(((Orders) order).getCustomer().getLastname());
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(((Orders) order).getBook().getNameBook());
		stringbuilder.append(PRICE_BOOK);
		stringbuilder.append(((Orders) order).getBook().getPrice());
		stringbuilder.append(DATE_ORDER);
		stringbuilder.append(((Orders) order).getDateOrder());
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

	public void printListCustomer(List<?> list) {
		for (Object customer : list) {
			System.out.println(printInfoCustomerOll(customer));
		}
	}

	public void printListWriter(List<?> list) {
		for (Object writerr : list) {
			System.out.println(printInfoWriterOll(writerr));
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
		System.out.println(message);
	}

}
