package com.senla.sobol.controller;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.senla.sobol.di.DI;
import com.senla.sobol.di.PropertyInstance;
import com.senla.sobol.intarfaces.IOnlineBook;
import com.senla.sobol.interfaces.IBookService;
import com.senla.sobol.interfaces.ICustomerService;
import com.senla.sobol.interfaces.IImportExport;
import com.senla.sobol.interfaces.IOrderService;
import com.senla.sobol.interfaces.IWriterService;
import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.Orders;
import com.senla.sobol.model.Writer;

public class OnlineBook implements IOnlineBook {
	private static final String DBEXPORTIMPORT = "dbexportimport";
	private static final String DATE_ORDER = "dateOrder";
	private static final String NAME_BOOK = "nameBook";
	private static final String QUANTITY_BOOK = "quantityBook";
	private static final String PRICE = "price";
	private static final String DD_MM_YYYY = "dd.MM.yyyy";
	private static final String LASTNAME_CUSTOMER = "lastname";
	private static final String LASTNAME_WRITER = "firstname";
	private static Logger log = Logger.getLogger(OnlineBook.class.getName());
	private IBookService bookservice;
	private IOrderService orderservice;
	private ICustomerService custonerservice;
	private IWriterService writerservice;
	private ImportExport importexport;
	private PropertyInstance propetyinstance;

	public OnlineBook() throws SQLException {
		try {
			bookservice = (IBookService) DI.load(IBookService.class);
			orderservice = (IOrderService) DI.load(IOrderService.class);
			writerservice = (IWriterService) DI.load(IWriterService.class);
			custonerservice = (ICustomerService) DI.load(ICustomerService.class);
			importexport = (ImportExport) DI.load(IImportExport.class);
			propetyinstance = (PropertyInstance) DI.load(PropertyInstance.class);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			log.error(e);
		}
	}

	public List<Book> getListBook() {
		List<Book> listbook = bookservice.getAll(null);
		return listbook;
	}

	public List<Orders> getListOrder() {
		List<Orders> listorder = orderservice.getAll(null);
		return listorder;
	}

	public List<Customer> getListCustomer() {
		List<Customer> listcustomer = custonerservice.getAll(null);
		return listcustomer;
	}

	public List<Writer> getListWriter() {
		List<Writer> listwriter = writerservice.getAll(null);
		return listwriter;
	}

	public void importWriterCSV() {
		List<Writer> listwriterimport = importexport.importWriterCSV(propetyinstance.load(DBEXPORTIMPORT));
		for (Writer writercsv : listwriterimport) {
			Writer writerimport = writerservice.getWriter(writercsv.getIdWriter());
			if (writerimport != null) {
				writerservice.update(writercsv);
			} else {
				writerservice.add(writercsv);
			}

		}
	}

	public void importCustomerCSV() {
		List<Customer> listcustomer = importexport.importCustomerCSV(propetyinstance.load(DBEXPORTIMPORT));
		for (Customer customercsv : listcustomer) {
			Customer customer = custonerservice.getCustomer(customercsv.getIdCustomer());
			if (customer != null) {
				custonerservice.update(customercsv);
			} else {
				custonerservice.add(customercsv);
			}
		}

	}

	public void exportBookCSV() {
		importexport.exportBookCSV(getListBook(), propetyinstance.load(DBEXPORTIMPORT));
	}

	public void exportOrderCSV() {
		importexport.exportOrderCSV(getListOrder(), propetyinstance.load(DBEXPORTIMPORT));

	}

	public void exportCustomerCSV() {
		importexport.exportCustomerCSV(getListCustomer(), propetyinstance.load(DBEXPORTIMPORT));
	}

	public void exportWriterCSV() {
		importexport.exportWriterCSV(getListWriter(), propetyinstance.load(DBEXPORTIMPORT));

	}

	public List<Orders> getListOrderByIdCustomer(Integer id) {
		List<Orders> listorder = orderservice.getOrderByDateAndId(id);
		return listorder;
	}

	public Integer getOrderPriceByCustomer(Integer id) {
		List<Orders> listorder = orderservice.getOrderByDateAndId(id);
		Integer price = new Integer(0);
		for (Orders order : listorder) {
			Integer quantity = order.getBook().getPrice();
			price += quantity;
		}
		return price;
	}

	public void addNewOrder(Integer idCustomer, Integer idBook) {
		SimpleDateFormat simpledate = new SimpleDateFormat(DD_MM_YYYY);
		Customer customer = custonerservice.getCustomer(idCustomer);
		Book book = bookservice.getBookId(idBook);
		if (customer != null && book != null) {
			Integer quantitybook = book.getQuantityPages();
			if (quantitybook != 0) {
				book.setQuantityPages(--quantitybook);
				orderservice.add(new Orders(book, customer, simpledate.format(new Date())));
			}
		}

	}

	public void addNewBook(Integer idWriter, String namebook, Integer quantitybook, Integer price) {
		Writer writer = writerservice.getWriter(idWriter);
		if (writer != null) {
			bookservice.add(new Book(writer, namebook, quantitybook, price));
		}

	}

	public void addNewWriter(String lastname, String firstname, String dateStart, String Dieddate) {
		if (Dieddate != null) {
			writerservice.add(new Writer(lastname, firstname, dateStart, Dieddate));
		} else {
			writerservice.add(new Writer(lastname, firstname, dateStart));
		}

	}

	public void addNewCustomer(String lastname, String firstname, Integer phone) {
		custonerservice.add(new Customer(lastname, firstname, phone));
	}

	public List<Orders> getSortOrderByDate() {
		List<Orders> listorder = orderservice.getAll(DATE_ORDER);
		return listorder;
	}

	public List<Book> getSortBookByName() {
		List<Book> listbook = bookservice.getAll(NAME_BOOK);
		return listbook;
	}

	public List<Book> getSortBookByDate() {
		List<Book> listbook = bookservice.getAll(QUANTITY_BOOK);
		return listbook;
	}

	public List<Book> getSortBookByPrice() {
		List<Book> listbook = bookservice.getAll(PRICE);
		return listbook;
	}

	public List<Customer> getSortCustomerName() {
		List<Customer> listcustomer = custonerservice.getAll(LASTNAME_CUSTOMER);
		return listcustomer;
	}

	public List<Writer> getSortWriterName() {
		List<Writer> listwriter = writerservice.getAll(LASTNAME_WRITER);
		return listwriter;
	}

	public void deleteOrder(Integer id) {
		Orders order = orderservice.getOrderId(id);
		if (order != null) {
			Book book = order.getBook();
			Integer quantity = book.getQuantityPages();
			book.setQuantityPages(++quantity);
			orderservice.delete(order);
			}

	}

	public void deleteWriter(Integer idWriter) {
		Writer writer = writerservice.getWriter(idWriter);
		if (writer != null) {
			writerservice.delete(writer);
		}

	}

	public void deleteCustomer(Integer idCustomer) {
		Customer customer = custonerservice.getCustomer(idCustomer);
		if (customer != null) {
			custonerservice.delete(customer);
		}
	}

	public void deleteBook(Integer idBook) {
		Book book = bookservice.getBookId(idBook);
		if (book != null) {
			bookservice.delete(book);
		}

	}

	public void closeDBConnector() {
		DBConnector.getInstance().closeDBConnector();
	}

}
