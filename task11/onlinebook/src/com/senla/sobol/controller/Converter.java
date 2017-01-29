package com.senla.sobol.controller;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IWriter;
import com.senla.sobol.model.Writer;

public class Converter {
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * convert string to integer
	 * 
	 * @param numberstring
	 * @return
	 */
	private Integer getTranslateNumber(String numberstring) {
		String withoutProbellov = numberstring.replaceAll(" ", "");
		Integer numberInteger = Integer.parseInt(withoutProbellov);
		return numberInteger;
	}

	/**
	 * merge two array
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private <T> T[] anAssociation(T[] A, T[] B) {
		int a = A.length;
		int b = B.length;
		T[] C = (T[]) Array.newInstance(A.getClass().getComponentType(), a + b);
		System.arraycopy(A, 0, C, 0, a);
		System.arraycopy(B, 0, C, a, b);
		return C;
	}

	/**
	 * merge two list
	 * 
	 * @param listorder
	 * @param listbook
	 * @return
	 */
	public String[] getOllArray(List<IOrder> listorder, List<IBook> listbook) {
		String[] array = anAssociation(getArrayBook(listbook), getArrayOrder(listorder));
		return array;

	}

	/**
	 * convert list Orders to string array
	 * 
	 * @param listorder
	 * @return
	 */
	public String[] getArrayOrder(List<IOrder> listorder) {
		int index = 0;
		String[] array = new String[listorder.size()];
		StringBuilder string;
		for (IOrder order : listorder) {
			string = new StringBuilder();
			string.append(order.getCustomer().getIdCustomer());
			string.append(",");
			string.append(order.getBook().getIdBook());
			string.append(",");
			string.append(convertDateToString(order.getDateOrder()));
			array[index] = string.toString();
			index++;
		}

		return array;

	}

	public String[] getArrayBook(List<IBook> listbook) {
		int index = 0;
		String[] array = new String[listbook.size()];
		StringBuilder string;
		for (IBook book : listbook) {
			string = new StringBuilder();
			string.append(book.getIdBook());
			string.append(",");
			string.append(book.getWriter().getIdWriter());
			string.append(",");
			string.append(book.getNameBook());
			string.append(",");
			string.append(book.getQuantityPages());
			string.append(",");
			string.append(book.getPrice());
			array[index] = string.toString();
			index++;
		}

		return array;

	}
	public String[] getArrayCustomer(List<ICustomer> listcustomer) {
		int index = 0;
		String[] array = new String[listcustomer.size()];
		StringBuilder string;
		for (ICustomer customer : listcustomer) {
			string = new StringBuilder();
			string.append(customer.getIdCustomer());
			string.append(",");
			string.append(customer.getFirstname());
			string.append(",");
			string.append(customer.getLastname());
			string.append(",");
			string.append(customer.getPhone());
			array[index] = string.toString();
			index++;
		}

		return array;

	}
	public String[] getArrayWriter(List<IWriter> listwriter) {
		int index = 0;
		String[] array = new String[listwriter.size()];
		StringBuilder string;
		for (IWriter writer : listwriter) {
			string = new StringBuilder();
			string.append(writer.getIdWriter());
			string.append(",");
			string.append(writer.getFirstname());
			string.append(",");
			string.append(writer.getLastname());
			string.append(",");
			string.append(convertDateToString(writer.getStartYear()));
			string.append(",");
			string.append(convertDateToString(writer.getDiedYear()));
			array[index] = string.toString();
			index++;
		}

		return array;

	}
	
	public List<IBook> getListBook(List<IBook> listbook, String[] array) {
		listbook = new ArrayList<IBook>();
		String[] masBook = array;

		for (int i = 0; i < masBook.length; i++) {
			String[] wordString = masBook[i].split(",");
				IBook book = new Book();
				for (int j = 1; j < wordString.length; j++) {
					if (j == 1) {
						book.setIdBook( getTranslateNumber(wordString[j])  );;

					} else if (j == 2) {
					// нужно решить что с Writer
					} else if (j == 3) {
						book.setQuantityPages(getTranslateNumber(wordString[j]));
					} else if (j == 4) {
						book.setPrice(getTranslateNumber(wordString[j]));
					} else if (j == 5) {
						book.setQuantityPages(getTranslateNumber(wordString[j]));
					} 			
				listbook.add(book);
			}
		}
		return listbook;
	}
	public List<IWriter> getListWriter(List<IWriter> listwriter, String[] array) throws ParseException {
		listwriter = new ArrayList<IWriter>();
		String[] masWriter = array;

		for (int i = 0; i < masWriter.length; i++) {
			String[] wordString = masWriter[i].split(",");
				IWriter writer=new Writer();
				for (int j = 0; j < wordString.length; j++) {
					if (j == 0) {
						writer.setIdWriter(getTranslateNumber(wordString[j]));
					} else if (j == 1) {
					writer.setLastname(wordString[j]);
					} else if (j == 2) {
						writer.setFirstname(wordString[j]);
					} else if (j == 3) {
						writer.setStartYear(convertStringToDate(wordString[j]));
					} else if (j == 4) {
						writer.setDiedYear(convertStringToDate(wordString[j]));
					} 			
					listwriter.add(writer);
			}
		}
		return listwriter;
	}
	public List<ICustomer> getListCustomer(List<ICustomer> listcustomer, String[] array) throws ParseException {
		listcustomer = new ArrayList<ICustomer>();
		String[] masCustomer = array;

		for (int i = 0; i < masCustomer.length; i++) {
			String[] wordString = masCustomer[i].split(",");
				ICustomer customer=new Customer();
				for (int j = 0; j < wordString.length; j++) {
					if (j == 0) {
						customer.setIdCustomer(getTranslateNumber(wordString[j]));
					} else if (j == 1) {
					customer.setLastname(wordString[j]);
					} else if (j == 2) {
					customer.setFirstname(wordString[j]);
					} else if (j == 3) {
						customer.setPhone(getTranslateNumber(wordString[j]));
					} 			
					listcustomer.add(customer);
			}
		}
		return listcustomer;
	}
		
	
	/**
	 * convert string to date
	 * 
	 * @param datestring
	 * @return
	 * @throws ParseException
	 */
	private Date convertStringToDate(String datestring) throws ParseException {
		Date date = simpledate.parse(datestring);
		return date;
	}

	/**
	 * convert date to string
	 * 
	 * @param date
	 * @return
	 */
	private String convertDateToString(Date date) {
		String datestring = simpledate.format(date);
		return datestring;
	}

}
