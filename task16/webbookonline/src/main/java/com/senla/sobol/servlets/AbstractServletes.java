package com.senla.sobol.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.senla.sobol.di.DI;
import com.senla.sobol.intarfaces.IOnlineBook;
import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.Orders;
import com.senla.sobol.model.Writer;

public abstract class AbstractServletes extends HttpServlet {

	private static final String NAME_WRITER = "NameWriter";
	private static final String PRICE_BOOK = "priceBook";
	private static final String LASTNAME_CUSTOMER = "lastnameCustomer";
	private static final String ID_ORDER = "idOrder";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IOnlineBook onlinebook = null;
	private static final String DATE_ORDER = "Dateorder";
	private static final String FIRSTNAME_ORDERS = "FirstnameOrders";
	private static final String NAME_BOOK = "nameBook";
	private static final String DIED_YEAR = "Diedyear";
	private static final String START_YEAR = "Startyear";
	private static final String LAST_N_AME = "LastNAme";
	private static final String FIRSTNAME = "Firstname";
	private static final String ID_WRITER = "idWriter";
	private static final String PRICE = "price";
	private static final String ID_BOOK = "idBook";
	private static final String PHONE = "Phone";
	private static final String ID_CUSTOMER = "idCustomer";
	private static final String QUANTITY_PAGES = "quantityPages";
	private Logger log = Logger.getLogger(AbstractServletes.class.getName());
	private SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy");

	public AbstractServletes() {
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			log.error(e);
		}
	}

	protected IOnlineBook getIOnlineBook() {
		return onlinebook;
	}

	protected JSONObject getJson(HttpServletRequest request) {
		JSONObject jsonobject = null;
		BufferedReader reader = null;

		try {
			reader = request.getReader();
			StringBuilder stringbuilder = new StringBuilder();
			String string = null;
			while ((string = reader.readLine()) != null) {
				stringbuilder.append(string);
			}
			JSONParser parser = new JSONParser();
			jsonobject = (JSONObject) parser.parse(stringbuilder.toString());
		} catch (IOException | ParseException e) {
			log.error(e);
		}
		return jsonobject;
	}

	protected JSONArray getJSONArrayWriter(List<Writer> getListWriter) {
		JSONArray jsonArray = new JSONArray();
		for (Writer writer : getListWriter) {
			JSONObject json = new JSONObject();
			json.put(ID_WRITER, writer.getIdWriter());
			json.put(FIRSTNAME, writer.getFirstname());
			json.put(LAST_N_AME, writer.getLastname());
			if (writer.getStartYear() != null) {
				json.put(START_YEAR, dateformat.format(writer.getStartYear()));
			} else {
				json.put(START_YEAR, writer.getStartYear());
			}
			if (writer.getDiedYear() != null) {
				json.put(DIED_YEAR, dateformat.format(writer.getDiedYear()));
			} else {
				json.put(START_YEAR, writer.getDiedYear());
			}

			jsonArray.add(json);
		}
		return jsonArray;
	}

	protected JSONArray getJSONArrayOrders(List<Orders> getListOrder) {
		JSONArray jsonArray = new JSONArray();
		for (Orders orders : getListOrder) {
			JSONObject json = new JSONObject();
			json.put(ID_ORDER, orders.getIdOrder());
			json.put(NAME_BOOK, orders.getBook().getNameBook());
			json.put(FIRSTNAME_ORDERS, orders.getCustomer().getFirstname());
			json.put(LASTNAME_CUSTOMER, orders.getCustomer().getLastname());
			json.put(PRICE_BOOK, orders.getBook().getPrice());
			json.put(DATE_ORDER, dateformat.format(orders.getDateOrder()));
			jsonArray.add(json);
		}
		return jsonArray;
	}

	protected JSONArray getJSONArrayBook(List<Book> getListBook) {
		JSONArray jsonArray = new JSONArray();
		for (Book book : getListBook) {
			JSONObject json = new JSONObject();
			json.put(ID_BOOK, book.getIdBook());
			json.put(NAME_WRITER, book.getWriter().getLastname());
			json.put(NAME_BOOK, book.getNameBook());
			json.put(PRICE, book.getPrice());
			json.put(QUANTITY_PAGES, book.getQuantityPages());
			jsonArray.add(json);
		}
		return jsonArray;
	}

	protected JSONArray getJSONArrayCustomer(List<Customer> getListCustomer) {
		JSONArray jsonArray = new JSONArray();
		for (Customer customer : getListCustomer) {
			JSONObject json = new JSONObject();
			json.put(ID_CUSTOMER, customer.getIdCustomer());
			json.put(FIRSTNAME, customer.getFirstname());
			json.put(LAST_N_AME, customer.getLastname());
			json.put(PHONE, customer.getPhone());
			jsonArray.add(json);
		}
		return jsonArray;
	}

	protected <T> JSONArray getJSONArrayGeneric(List<T> getList)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		JSONArray jsonArray = new JSONArray();
		for (T t : getList) {
			JSONObject json = new JSONObject();
			Class clazz = t.getClass();
			Field[] field = clazz.getDeclaredFields();
			for (Field fierlds : field) {
				fierlds.setAccessible(true);
				System.out.println(fierlds.getName() + fierlds.get(fierlds.getName()));
				// json.put();
			}
			jsonArray.add(json);
		}
		return jsonArray;
	}
}
