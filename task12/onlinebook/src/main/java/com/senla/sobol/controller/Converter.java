package com.senla.sobol.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.Orders;
import com.senla.sobol.model.Writer;

public class Converter {
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
	 * convert list Orders to string array
	 * 
	 * @param listorder
	 * @return
	 */
	public String[] getArrayOrder(List<Orders> listorder) {
		int index = 0;
		String[] array = new String[listorder.size()];
		StringBuilder string;
		for (Orders order : listorder) {
			string = new StringBuilder();
			string.append(order.getCustomer().getIdCustomer());
			string.append(",");
			string.append(order.getBook().getIdBook());
			string.append(",");
		    string.append(order.getDateOrder());
			array[index] = string.toString();
			index++;
		}

		return array;

	}

	public String[] getArrayBook(List<Book> listbook) {
		int index = 0;
		String[] array = new String[listbook.size()];
		StringBuilder string;
		for (Book book : listbook) {
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

	public String[] getArrayCustomer(List<Customer> listcustomer) {
		int index = 0;
		String[] array = new String[listcustomer.size()];
		StringBuilder string;
		for (Customer customer : listcustomer) {
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

	public String[] getArrayWriter(List<Writer> listwriter) {
		int index = 0;
		String[] array = new String[listwriter.size()];
		StringBuilder string;
		for (Writer writer : listwriter) {
			string = new StringBuilder();
			string.append(writer.getIdWriter());
			string.append(",");
			string.append(writer.getFirstname());
			string.append(",");
			string.append(writer.getLastname());
			string.append(",");
			string.append(writer.getStartYear());
			string.append(",");
			string.append(writer.getDiedYear());
			array[index] = string.toString();
			index++;
		}

		return array;

	}

	public List<Book> getListBook(List<Book> listbook, String[] array) {
		listbook = new ArrayList<Book>();
		String[] masBook = array;

		for (int i = 0; i < masBook.length; i++) {
			String[] wordString = masBook[i].split(",");
			Book book = new Book();
			for (int j = 1; j < wordString.length; j++) {
				if (j == 1) {
					book.setIdBook(getTranslateNumber(wordString[j]));
					;

				} else if (j == 2) {
					// ����� ������ ��� � Writer
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

	public List<Writer> getListWriter(List<Writer> listwriter, String[] array) throws ParseException {
		listwriter = new ArrayList<Writer>();
		String[] masWriter = array;

		for (int i = 0; i < masWriter.length; i++) {
			String[] wordString = masWriter[i].split(",");
			Writer writer = new Writer();
			for (int j = 0; j < wordString.length; j++) {
				if (j == 0) {
					writer.setIdWriter(getTranslateNumber(wordString[j]));
				} else if (j == 1) {
					writer.setLastname(wordString[j]);
				} else if (j == 2) {
					writer.setFirstname(wordString[j]);
				} else if (j == 3) {
				 writer.setStartYear(wordString[j]);
				} else if (j == 4) {
				 writer.setDiedYear(wordString[j]);
				}
				listwriter.add(writer);
			}
		}
		return listwriter;
	}

	public List<Customer> getListCustomer(List<Customer> listcustomer, String[] array) throws ParseException {
		listcustomer = new ArrayList<Customer>();
		String[] masCustomer = array;

		for (int i = 0; i < masCustomer.length; i++) {
			String[] wordString = masCustomer[i].split(",");
			Customer customer = new Customer();
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


}
