package controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import com.mysql.jdbc.Connection;
import com.senla.sobol.di.DI;
import com.senla.sobol.di.PropertyInstance;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOnlineBook;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IWriter;
import dao.BookDao;
import dao.CustomerDao;
import dao.OrderDao;
import dao.WriterDao;
import interfaces.IBookDao;
import interfaces.IBookService;
import interfaces.ICustomerDao;
import interfaces.ICustomerService;
import interfaces.IImportExport;
import interfaces.IOrderDao;
import interfaces.IOrderService;
import interfaces.IWriterDao;
import interfaces.IWriterService;
import model.Book;
import model.Customer;
import model.Order;
import model.Writer;
import service.BookService;
import service.CustomerService;
import service.OrderService;
import service.WriterService;
import sort.SortBookName;
import sort.SortBookPrice;
import sort.SortBookQuantity;
import sort.SortCustomerName;
import sort.SortDateOrder;
import sort.SortWriterName;

public class OnlineBook implements IOnlineBook {
	private static Logger log = Logger.getLogger(OnlineBook.class.getName());
	private IBookService bookservice;
	private IOrderService orderservice;
	private ICustomerService custonerservice;
	private IWriterService writerservice;
	private ImportExport importexport;
	private PropertyInstance propetyinstance;

	public OnlineBook() throws SQLException {
		Connection connection = (Connection) CreatConnectionOne.getInstance().getConnection();
		try {
			IBookDao bookdao = (BookDao) DI.load(IBookDao.class);
			bookdao.setConnection(connection);
			ICustomerDao customer = (CustomerDao) DI.load(ICustomerDao.class);
			customer.setConnection(connection);
			IWriterDao writerdao = (WriterDao) DI.load(IWriterDao.class);
			writerdao.setConnection(connection);
			IOrderDao orderdao = (OrderDao) DI.load(IOrderDao.class);
			orderdao.setConnection(connection);
			bookservice = (BookService) DI.load(IBookService.class);
			bookservice.setBookdao(bookdao);
			orderservice = (OrderService) DI.load(IOrderService.class);
			orderservice.setOrderdao(orderdao);
			writerservice = (WriterService) DI.load(IWriterService.class);
			writerservice.setWriterdao(writerdao);
			custonerservice = (CustomerService) DI.load(ICustomerService.class);
			custonerservice.setCustomerdao(customer);
			importexport = (ImportExport) DI.load(IImportExport.class);
			propetyinstance = (PropertyInstance) DI.load(PropertyInstance.class);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			log.error(e);
		}
	}

	public List<IBook> getListBook() {
		List<IBook> listbook = bookservice.getAll();
		return listbook;
	}

	public List<IOrder> getListOrder() {
		List<IOrder> listorder = orderservice.getAll();
		return listorder;
	}

	public List<ICustomer> getListCustomer() {
		List<ICustomer> listcustomer = custonerservice.getAll();
		return listcustomer;
	}

	public List<IWriter> getListWriter() {
		List<IWriter> listwriter = writerservice.getAll();
		return listwriter;
	}

	public void importWriterCSV() {
		List<IWriter> listwriterimport = importexport.importWriterCSV(propetyinstance.load("dbexportimport"));
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
		List<ICustomer> listcustomer = importexport.importCustomerCSV(propetyinstance.load("dbexportimport"));
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
		importexport.exportBookCSV(getListBook(), propetyinstance.load("dbexportimport"));
	}

	public void exportOrderCSV() {
		importexport.exportOrderCSV(getListOrder(), propetyinstance.load("dbexportimport"));

	}

	public void exportCustomerCSV() {
		importexport.exportCustomerCSV(getListCustomer(), propetyinstance.load("dbexportimport"));
	}

	public void exportWriterCSV() {
		importexport.exportWriterCSV(getListWriter(), propetyinstance.load("dbexportimport"));

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
		SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");
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
		List<IOrder> listorder = orderservice.getAll();
		Collections.sort(listorder, new SortDateOrder());
		return listorder;
	}

	public List<IBook> getSortBookByName() {
		List<IBook> listbook = bookservice.getAll();
		Collections.sort(listbook, new SortBookName());
		return listbook;
	}

	public List<IBook> getSortBookByDate() {
		List<IBook> listbook = bookservice.getAll();
		Collections.sort(listbook, new SortBookQuantity());
		return listbook;
	}

	public List<IBook> getSortBookByPrice() {
		List<IBook> listbook = bookservice.getAll();
		Collections.sort(listbook, new SortBookPrice());
		return listbook;
	}

	public List<ICustomer> getSortCustomerName() {
		List<ICustomer> listcustomer = custonerservice.getAll();
		Collections.sort(listcustomer, new SortCustomerName());
		return listcustomer;
	}

	public List<IWriter> getSortWriterName() {
		List<IWriter> listwriter = writerservice.getAll();
		Collections.sort(listwriter, new SortWriterName());
		return listwriter;
	}

	public void deleteOrder(Integer idCustomer, Integer idBook, String date) {
		SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");
		try {
			IOrder order = orderservice.getOrder(idCustomer, idBook, simpledate.parse(date));
			if (order != null) {
				orderservice.delete(order);
				IBook book = bookservice.getBook(idBook);
				Integer number = book.getQuantityPages();
				book.setQuantityPages(++number);
				bookservice.update(book);
			}
		} catch (ParseException e) {
			log.error(e);
		}

	}

	public void deleteWriter(Integer idWriter) {
		IWriter writer = writerservice.getWriter(idWriter);
		if (writer != null && !bookservice.searchIdWriter(idWriter)) {
			writerservice.delete(writer);
		}

	}

	public void deleteCustomer(Integer idCustomer) {
		ICustomer customer = custonerservice.getCustomer(idCustomer);
		if (customer != null) {
			custonerservice.delete(customer);
		}
	}

	public void deleteBook(Integer idBook) {
		IBook book = bookservice.getBook(idBook);
		if (book != null && !orderservice.searchIdBook(idBook)) {
			bookservice.delete(book);
		}
	}

}
