package com.senla.sobol.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.senla.sobol.di.DI;
import com.senla.sobol.di.PropertyInstance;
import com.senla.sobol.interfaces.IBookService;
import com.senla.sobol.interfaces.ICustomerService;
import com.senla.sobol.interfaces.IImportExport;
import com.senla.sobol.interfaces.IOrderService;
import com.senla.sobol.interfaces.IWriterService;
import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOnlineBook;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IWriter;
import com.senla.sobol.model.Order;
import com.senla.sobol.model.Writer;

public class OnlineBook implements IOnlineBook {
	private static final String DBEXPORTIMPORT = "dbexportimport";
	private static final String DATE_ORDER = "dateOrder";
	private static final String NAME_BOOK = "nameBook";
	private static final String QUANTITY_BOOK = "quantityBook";
	private static final String PRICE = "price";
	private static final String DD_MM_YYYY = "dd.MM.yyyy";
	private static final String LASTNAME_CUSTOMER = "lastnameCustomer";
	private static final String LASTNAME_WRITER = "lastnameWriter";
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

	public List<IBook> getListBook() {
		List<IBook> listbook = bookservice.getAll(null);
		return listbook;
	}

	public List<IOrder> getListOrder() {
		List<IOrder> listorder = orderservice.getAll(null);
		return listorder;
	}

	public List<ICustomer> getListCustomer() {
		List<ICustomer> listcustomer = custonerservice.getAll(null);
		return listcustomer;
	}

	public List<IWriter> getListWriter() {
		List<IWriter> listwriter = writerservice.getAll(null);
		return listwriter;
	}

	public void importWriterCSV() {
		List<IWriter> listwriterimport = importexport.importWriterCSV(propetyinstance.load(DBEXPORTIMPORT));
		for (IWriter writercsv : listwriterimport) {
			IWriter writerimport = writerservice.getWriter(writercsv.getIdWriter());
			if (writerimport != null) {
				writerservice.update(writercsv);
			} else {
				writerservice.add(writercsv);
			}

		}
	}

	public void importCustomerCSV() {
		List<ICustomer> listcustomer = importexport.importCustomerCSV(propetyinstance.load(DBEXPORTIMPORT));
		for (ICustomer customercsv : listcustomer) {
			ICustomer customer = custonerservice.getCustomer(customercsv.getIdCustomer());
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

	public List<IOrder> getListOrderByIdCustomer(Integer id, String date) {
		List<IOrder> listorder = orderservice.getOrderByDateAndId(id, date);
		return listorder;
	}

	public Integer getOrderPriceByCustomer(Integer id, String date) {
		List<IOrder> listorder = orderservice.getOrderByDateAndId(id, date);
		Integer price = null;
		for (IOrder order : listorder) {
			Integer quantity = order.getBook().getPrice();
			price += quantity;
		}
		return price;
	}

	public void addNewOrder(Integer idCustomer, Integer idBook) {
		ICustomer customer = custonerservice.getCustomer(idCustomer);
		IBook book = bookservice.getBook(idBook);
		if (customer != null && book != null) {
			Integer quantitybook = book.getQuantityPages();
			if (quantitybook != 0) {
				book.setQuantityPages(--quantitybook);
				orderservice.add(new Order(book, customer, new Date()));

			}

		}

	}

	public void addNewBook(Integer idWriter, String namebook, Integer quantitybook, Integer price) {
		IWriter writer = writerservice.getWriter(idWriter);
		if (writer != null) {
			bookservice.add(new Book(writer, namebook, quantitybook, price));
		}

	}

	public void addNewWriter(String lastname, String firstname, String dateStart, String Dieddate) {
		SimpleDateFormat simpledate = new SimpleDateFormat(DD_MM_YYYY);
		try {
			writerservice.add(new Writer(lastname, firstname, simpledate.parse(dateStart), simpledate.parse(Dieddate)));
		} catch (ParseException e) {
			log.error(e);
		}
	}

	public void addNewCustomer(String lastname, String firstname, Integer phone) {
		custonerservice.add(new Customer(lastname, lastname, phone));
	}

	public List<IOrder> getSortOrderByDate() {
		List<IOrder> listorder = orderservice.getAll(DATE_ORDER);
		return listorder;
	}

	public List<IBook> getSortBookByName() {
		List<IBook> listbook = bookservice.getAll(NAME_BOOK);
		return listbook;
	}

	public List<IBook> getSortBookByDate() {
		List<IBook> listbook = bookservice.getAll(QUANTITY_BOOK);
		return listbook;
	}

	public List<IBook> getSortBookByPrice() {
		List<IBook> listbook = bookservice.getAll(PRICE);
		return listbook;
	}

	public List<ICustomer> getSortCustomerName() {
		List<ICustomer> listcustomer = custonerservice.getAll(LASTNAME_CUSTOMER);
		return listcustomer;
	}

	public List<IWriter> getSortWriterName() {
		List<IWriter> listwriter = writerservice.getAll(LASTNAME_WRITER);
		return listwriter;
	}

	public void deleteOrder(Integer idCustomer, Integer idBook, String date) {
		SimpleDateFormat simpledate = new SimpleDateFormat(DD_MM_YYYY);
		try {
			IOrder order = orderservice.getOrder(idCustomer, idBook, simpledate.parse(date));
			if (order != null) {
				IBook book = order.getBook();
				Integer quantity = book.getQuantityPages();
				book.setQuantityPages(++quantity);
				orderservice.delete(order);
			}
		} catch (ParseException e) {
			log.error(e);
		}

	}

	public void deleteWriter(Integer idWriter) {
		if (!bookservice.searchIdWriter(idWriter)) {
			writerservice.delete(idWriter);
		}

	}

	public void deleteCustomer(Integer idCustomer) {
		ICustomer customer = custonerservice.getCustomer(idCustomer);
		if (customer != null) {
			custonerservice.delete(idCustomer);
		}
	}

	public void deleteBook(Integer idBook) {
		IBook book = bookservice.getBook(idBook);
		if (book != null && !orderservice.searchIdBook(idBook)) {
			bookservice.delete(idBook);
		}
	}

	public void closeDBConnector() {
		try {
			DBConnector.getInstance().closeDBConnector();
		} catch (SQLException e) {
			log.error(e);
		}
	}

}
