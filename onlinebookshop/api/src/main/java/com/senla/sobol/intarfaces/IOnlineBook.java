package com.senla.sobol.intarfaces;

import java.util.List;

import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.Orders;
import com.senla.sobol.model.Writer;

public interface IOnlineBook {
	public List<Book> getListBook();

	public List<Orders> getListOrder();

	public List<Customer> getListCustomer();

	public List<Writer> getListWriter();

	public void exportBookCSV();

	public void exportOrderCSV();

	public void exportCustomerCSV();

	public void exportWriterCSV();

	public void addNewOrder(Integer idCustomer, Integer idBook);

	public void addNewBook(Integer idWriter, String namebook, Integer quantitybook, Integer price);

	public void addNewWriter(String lastname, String firstname, String dateStart, String Dieddate);

	public void addNewCustomer(String lastname, String firstname, Integer phone);

	public List<Orders> getSortOrderByDate();

	public List<Book> getSortBookByName();

	public List<Book> getSortBookByDate();

	public List<Book> getSortBookByPrice();

	public List<Customer> getSortCustomerName();

	public List<Writer> getSortWriterName();

	public void deleteOrder(Integer id);

	public void deleteWriter(Integer idWriter);

	public void deleteCustomer(Integer idCustomer);

	public void deleteBook(Integer idBook);

	public Integer getOrderPriceByCustomer(Integer id);

	public List<Orders> getListOrderByIdCustomer(Integer id);

	public void importWriterCSV();

	public void importCustomerCSV();

	public void closeDBConnector();

}