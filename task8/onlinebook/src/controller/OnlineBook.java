package controller;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.senla.sobol.di.DI;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.IOnlineBook;
import com.senla.sobol.model.IOrder;
import com.sobol.senla.anotation.PrintableTracker;

import interfaces.IBookDao;
import interfaces.IBookService;
import interfaces.IImportExport;
import interfaces.IOrderDao;
import interfaces.IOrderService;
import interfaces.ISeriazeble;
import model.Book;
import model.Order;
import property.PropertiesOnlineBook;
import sort.SortBookDate;
import sort.SortBookName;
import sort.SortBookPrice;
import sort.SortBookStock;
import sort.SortDateOrder;
import sort.SortPriceOrder;
import sort.SortStageOrder;

public class OnlineBook implements IOnlineBook {
	private static Logger log = Logger.getLogger(OnlineBook.class.getName());
	private IImportExport importexport;
	private IBookService bookService;
	private IOrderService orderservice;
	private ISeriazeble seriazeble;

	public OnlineBook() throws ParseException {

		try {
			seriazeble = (ISeriazeble) DI.load(ISeriazeble.class);
			importexport = (IImportExport) DI.load(IImportExport.class);
			IBookDao bookdao = (IBookDao) DI.load(IBookDao.class);
			bookdao.setListbook(seriazeble.getListBook());
			IOrderDao orderdao = (IOrderDao) DI.load(IOrderDao.class);
			orderdao.setListorder(seriazeble.getListOrder());
			this.bookService = (IBookService) DI.load(IBookService.class);
			bookService.setBookdao(bookdao);
			this.orderservice = (IOrderService) DI.load(IOrderService.class);
			orderservice.setOrderdao(orderdao);
			orderservice.setBookservice(this.bookService);
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}
	}

	/**
	 * return true if order add succes
	 * 
	 * @param lastname
	 * @param firstname
	 * @param namebook
	 * @return
	 * @throws ParseException
	 */
	public Boolean addOrder(String lastname, String firstname, String namebook) throws ParseException {
		if (orderservice.createNewOrder(lastname, firstname, namebook)) {
			return true;
		}
		return false;

	}

	/**
	 * add new book to databases
	 * 
	 * @param name
	 * @param writer
	 * @param price
	 * @param quantity
	 */

	public void addNewBook(String name, String writer, Integer price, Integer quantity) {
		bookService.addBook(new Book(name, writer, price, quantity));
	}

	/**
	 * close order in databases
	 * 
	 * @param lastname
	 * @param firstname
	 */
	public void closeOrder(String lastname, String firstname) {
		orderservice.closeOrder(lastname, firstname);
	}

	/**
	 * delete book in databases
	 * 
	 * @param name
	 */

	public void deleteBook(String name) {
		synchronized (bookService) {
			bookService.deleteBook(name);
		}

	}

	/**
	 * return true if delete order sucess
	 */

	public Boolean deleteOrder(String name) {
		synchronized (orderservice) {
			if (orderservice.deleteOrder(name)) {
				return true;
			}

			return false;
		}

	}

	/**
	 * sort list books by name
	 * 
	 */
	public List<IBook> sortBookName() {
		List<IBook> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookName());
		return listbook;
	}

	/**
	 * sort list books by price
	 *
	 */
	public List<IBook> sortBookPrice() {
		List<IBook> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookPrice());
		return listbook;

	}

	/**
	 * sort list books by dates
	 *
	 */
	public List<IBook> sortBookDate() {
		List<IBook> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookDate());
		return listbook;

	}

	/**
	 * sort list books by where is the stock
	 * 
	 */
	public List<IBook> sortBookStage() {
		List<IBook> listbook = bookService.getListBook();
		Collections.sort(listbook, new SortBookStock());
		return listbook;
	}

	public List<IOrder> sortOrderDate() {
		List<IOrder> listbook = orderservice.getListOrder();
		Collections.sort(listbook, new SortDateOrder());
		return listbook;
	}

	public List<IOrder> sortOrderPrice() {
		List<IOrder> listbook = orderservice.getListOrder();
		Collections.sort(listbook, new SortPriceOrder());
		return listbook;
	}

	public List<IOrder> sortOrderStage() {
		List<IOrder> listbook = orderservice.getListOrder();
		Collections.sort(listbook, new SortStageOrder());
		return listbook;
	}

	/**
	 * save changes in databases
	 */
	public void saveToDataBases() {
		synchronized (seriazeble) {
			seriazeble.saveToDataBases();
		}

	}

	public List<IOrder> sortOrderDateToDate(String date1, String date2) throws ParseException {
		List<IOrder> listorder = orderservice.getListOrderClock(date1, date2);
		Collections.sort(listorder, new SortDateOrder());
		return listorder;
	}

	public List<IOrder> sortOrderDateToPrice(String date1, String date2) throws ParseException {
		List<IOrder> listorder = orderservice.getListOrderClock(date1, date2);
		Collections.sort(listorder, new SortPriceOrder());
		return listorder;
	}

	public Integer printOrderPriceToOrder(String date1, String date2) throws ParseException {
		List<IOrder> listorder = orderservice.getListOrderClock(date1, date2);
		Integer priceOll = 0;
		for (IOrder order : listorder) {
			priceOll += order.getPrice();
		}

		return priceOll;
	}

	public Integer printOrderFinish(String date1, String date2) throws ParseException {
		List<IOrder> listorder = orderservice.getListOrderClock(date1, date2);
		Integer orderOll = 0;
		for (IOrder order : listorder) {
			orderOll++;
		}

		return orderOll;
	}

	public List<IOrder> getListOrderAll() {
		List<IOrder> listorder = orderservice.getListOrder();
		return listorder;
	}

	public List<IBook> getListBookAll() {
		List<IBook> listbook = bookService.getListBook();
		return listbook;
	}

	public void exportBookCSV() {
		importexport.exportBookCSV(getListBookAll(),
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getRoatimportexportBook());
	}

	public void exportOrderCSV() {
		importexport.exportOrderCSV(getListOrderAll(),
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getRoatimportexportOrder());

	}

	/**
	 * marks the application as completed
	 */

	public void orderSales(String nameorder) {
		Boolean sales = PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getSalesorder();
		IOrder order = orderservice.searchOrder(nameorder);
		if (order != null) {
			if (sales) {
				orderservice.closeOrder(order.getLastname(), order.getFirstname());
			} else {
				orderservice.deleteOrder(order.getLastname());
			}
		}
	}

	public void importBookCSV() {
		List<IBook> listbook = importexport.importBookCSV(
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getRoatimportexportBook());
		if (listbook != null) {
			for (IBook book : listbook) {
				IBook book2 = bookService.searchBook(book.getName());
				if (book2 != null) {
					bookService.updateBook(book, book2);
				} else {
					bookService.addBook(book);
				}
			}

		}
	}

	/**
	 * clone_object
	 * 
	 * @param nameclone
	 * @return
	 * @throws CloneNotSupportedException
	 */

	public void cloneOrder(String nameclone) throws CloneNotSupportedException {
		IOrder order = null;
		if (orderservice.searchOrder(nameclone) != null) {
			order = orderservice.searchOrder(nameclone).clone();
			order.setIdNumberOrder(UUID.randomUUID().toString());
			orderservice.addCloneOrder(order);
		}

	}

	/**
	 * import file in CSV
	 */
	public void importOrderCSV() {
		List<IOrder> listorder = importexport.importOrderCSV(
				PropertiesOnlineBook.getInstanceProperty().getInstancePropertyHolder().getRoatimportexportOrder());
		if (listorder != null) {
			for (IOrder order : listorder) {
				IOrder order2 = orderservice.searchOrderById(order.getIdNumberOrder());
				if (order2 != null) {
					orderservice.updateOrder(order, order2);
				} else {
					try {
						orderservice.createNewOrder(order.getLastname(), order.getFirstname(),
								order.getBook().getName());
					} catch (ParseException e) {
						log.error(e);
					}
				}

			}
		}
	}

	public String getAnnotationBook() {
		String information = null;
		try {
			information = PrintableTracker.getInstance().prinInformation(Book.class, true);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}
		return information;
	}

	public String getAnnotationOrder() {
		String information = null;
		try {
			information = PrintableTracker.getInstance().prinInformation(Order.class, true);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}
		return information;
	}

}
