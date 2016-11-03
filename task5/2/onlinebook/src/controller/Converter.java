package controller;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Book;
import model.Order;
import model.StageBook;

public class Converter {
	private SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");

	// convert string to integer
	private Integer getTranslateNumber(String numberstring) {
		String withoutProbellov = numberstring.replaceAll(" ", "");
		Integer numberInteger = Integer.parseInt(withoutProbellov);
		return numberInteger;
	}

	// merge two array
	private <T> T[] anAssociation(T[] A, T[] B) {
		int a = A.length;
		int b = B.length;
		T[] C = (T[]) Array.newInstance(A.getClass().getComponentType(), a + b);
		System.arraycopy(A, 0, C, 0, a);
		System.arraycopy(B, 0, C, a, b);
		return C;
	}

	// merge two list
	public String[] getOllArray(List<Order> listorder, List<Book> listbook) {
		String[] array = anAssociation(getArrayBook(listbook), getArrayOrder(listorder));
		return array;

	}

	// convert list Orders to string array
	private String[] getArrayOrder(List<Order> listorder) {
		int index = 0;
		String[] array = new String[listorder.size()];
		StringBuilder string;
		for (Order order : listorder) {
			string = new StringBuilder();
			string.append("2");
			string.append(",");
			string.append(order.getIdNumberOrder());
			string.append(",");
			string.append(order.getLastname());
			string.append(",");
			string.append(order.getFirstname());
			string.append(",");
			string.append(order.getBook().getName());
			string.append(",");
			string.append(order.getPrice());
			string.append(",");
			string.append(convertDateToString(order.getDate()));
			string.append(",");
			string.append(convertDateToString(order.getDateFinishOrder()));
			string.append(",");
			string.append(order.getStage().toString());
			array[index] = string.toString();
			index++;
		}

		return array;

	}

	// convert list Books to String array
	private String[] getArrayBook(List<Book> listbook) {
		int index = 0;
		String[] array = new String[listbook.size()];
		StringBuilder string;
		for (Book book : listbook) {
			string = new StringBuilder();
			string.append("1");
			string.append(",");
			string.append(book.getName());
			string.append(",");
			string.append(book.getWriter());
			string.append(",");
			string.append(book.getId());
			string.append(",");
			string.append(book.getPrice());
			string.append(",");
			string.append(book.getQuantityPages());
			string.append(",");
			string.append(book.getStage().toString());
			array[index] = string.toString();
			index++;

		}

		return array;
	}

	// convert string array to list Books
	public List<Book> getListBook(List<Book> listbook, String[] array) {
		listbook = new ArrayList<Book>();
		String[] masBook = array;

		for (int i = 0; i < masBook.length; i++) {
			String[] wordString = masBook[i].split(",");
			if (wordString[0].equals("1")) {
				Book book = new Book();
				for (int j = 1; j < wordString.length; j++) {
					if (j == 1) {
						book.setName(wordString[j]);

					} else if (j == 2) {
						book.setWriter(wordString[j]);
					} else if (j == 3) {
						book.setId(wordString[j]);
					} else if (j == 4) {
						book.setPrice(getTranslateNumber(wordString[j]));
					} else if (j == 5) {
						book.setQuantityPages(getTranslateNumber(wordString[j]));
					} else {
						book.setStage( convertStage(wordString[j] ) );
					}
				}

				listbook.add(book);
			}

		}
		return listbook;
	}

	
	private StageBook convertStage(String word){
		StageBook stagebook=StageBook.valueOf(word);
		return stagebook;
	}
		
	// convert string array to list Order
	public List<Order> getListOrder(List<Order> listorder, String[] array) throws ParseException {
		listorder = new ArrayList<Order>();
		String[] masBook = array;

		for (int i = 0; i < masBook.length; i++) {
			String[] wordString = masBook[i].split(",");
			if (wordString[0].equals("2")) {
				Order order = new Order();
				for (int j = 1; j < wordString.length; j++) {
					if (j == 1) {
						order.setIdNumberOrder((wordString[j]));
					} else if (j == 2) {
						order.setLastname(wordString[j]);
					} else if (j == 3) {
						order.setFirstname(wordString[j]);
					} else if (j == 4) {
						order.setBook(new Book(wordString[j]));
					} else if (j == 5) {
						order.setPrice(getTranslateNumber(wordString[j]));
					} else if (j == 6) {
						order.setDate(convertStringToDate(wordString[j]));
					} else if (j == 7) {
						order.setDateFinishOrder(convertStringToDate(wordString[j]));
					} else {
						order.setStage(convertStage(wordString[j]));
					}
				}
				listorder.add(order);
			}

		}
		return listorder;
	}

	// convert string to date
	private Date convertStringToDate(String datestring) throws ParseException {
		Date date = simpledate.parse(datestring);
		return date;
	}

	// convert date to string
	private String convertDateToString(Date date) {
		String datestring = simpledate.format(date);
		return datestring;
	}

}
