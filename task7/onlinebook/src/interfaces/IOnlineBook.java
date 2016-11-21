package interfaces;

import java.text.ParseException;
import java.util.List;

import model.Book;
import model.Order;

public interface IOnlineBook {
	public Boolean addOrder(String lastname, String firstname, String namebook) throws ParseException;

	public void addNewBook(String name, String writer, Integer price, Integer quantity);

	public void closeOrder(String lastname, String firstname);

	public void deleteBook(String name);

	public Boolean deleteOrder(String name);

	public List<Book> sortBookName();

	public List<Book> sortBookPrice();

	public List<Book> sortBookDate();

	public List<Book> sortBookStage();

	public List<Order> sortOrderDate();

	public List<Order> sortOrderPrice();

	public List<Order> sortOrderStage();

	public void saveToDataBases();

	public List<Order> sortOrderDateToDate(String date1, String date2) throws ParseException;

	public List<Order> sortOrderDateToPrice(String date1, String date2) throws ParseException;

	public Integer printOrderPriceToOrder(String date1, String date2) throws ParseException;

	public Integer printOrderFinish(String date1, String date2) throws ParseException;

	public List<Order> getListOrderAll();

	public List<Book> getListBookAll();

	public void exportBookCSV();

	public void exportOrderCSV();

	public void orderSales(String nameorder);

	public void importBookCSV();

}
