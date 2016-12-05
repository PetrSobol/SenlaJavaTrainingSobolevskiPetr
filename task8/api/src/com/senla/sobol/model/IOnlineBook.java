package com.senla.sobol.model;

import java.text.ParseException;
import java.util.List;

import com.senla.sobol.model.IBook;
import com.senla.sobol.model.IOrder;

public interface IOnlineBook {
	public Boolean addOrder(String lastname, String firstname, String namebook) throws ParseException;

	public void addNewBook(String name, String writer, Integer price, Integer quantity);

	public void closeOrder(String lastname, String firstname);

	public void deleteBook(String name);

	public Boolean deleteOrder(String name);

	public List<IBook> sortBookName();

	public List<IBook> sortBookPrice();

	public List<IBook> sortBookDate();

	public List<IBook> sortBookStage();

	public List<IOrder> sortOrderDate();

	public List<IOrder> sortOrderPrice();

	public List<IOrder> sortOrderStage();

	public void saveToDataBases();

	public List<IOrder> sortOrderDateToDate(String date1, String date2) throws ParseException;

	public List<IOrder> sortOrderDateToPrice(String date1, String date2) throws ParseException;

	public Integer printOrderPriceToOrder(String date1, String date2) throws ParseException;

	public Integer printOrderFinish(String date1, String date2) throws ParseException;

	public List<IOrder> getListOrderAll();

	public List<IBook> getListBookAll();

	public void exportBookCSV();

	public void exportOrderCSV();

	public void orderSales(String nameorder);

	public void importBookCSV();

	public void cloneOrder(String nameclone) throws CloneNotSupportedException;

	public void importOrderCSV();

	public String getAnnotationBook();

	public String getAnnotationOrder();

}