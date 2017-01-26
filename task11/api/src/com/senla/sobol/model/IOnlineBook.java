package com.senla.sobol.model;

import java.util.List;

public interface IOnlineBook {
	public List<IBook> getListBook();

	public List<IOrder> getListOrder();

	public List<ICustomer> getListCustomer();

	public List<IWriter> getListWriter();

	public void exportBookCSV();

	public void exportOrderCSV();

	public void exportCustomerCSV();

	public void exportWriterCSV();

	public void addNewOrder(Integer idCustomer, Integer idBook);

	public void addNewBook(Integer idWriter, String namebook, Integer quantitybook, Integer price);

	public void addNewWriter(String lastname, String firstname, String dateStart, String Dieddate);

	public void addNewCustomer(String lastname, String firstname, Integer phone);

	public List<IOrder> getSortOrderByDate();

	public List<IBook> getSortBookByName();

	public List<IBook> getSortBookByDate();

	public List<IBook> getSortBookByPrice();

	public List<ICustomer> getSortCustomerName();

	public List<IWriter> getSortWriterName();

	public void deleteOrder(Integer idCustomer, Integer idBook, String date);

	public void deleteWriter(Integer idWriter);

	public void deleteCustomer(Integer idCustomer);

	public void deleteBook(Integer idBook);

	public Integer getOrderPriceByCustomer(Integer id, String date);

	public List<IOrder> getListOrderByIdCustomer(Integer id, String date);

	public void importWriterCSV();

	public void importCustomerCSV();

	public void closeDBConnector();

}