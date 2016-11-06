package controller;

import model.Book;
import model.Order;

public class Runner {

	public static void main(String[] args) {
		// OnlineBook.getInstance().addNewBook("sadsad", "sadsa", 11, 123);
		for (Book book : OnlineBook.getInstance().getListBookAll()) {
			System.out.println(book.getName());

		}
		for (Order order : OnlineBook.getInstance().getListOrderAll()) {
			System.out.println(order.getLastname());
		}
       OnlineBook.getInstance().importBookCSV();
       for (Book book : OnlineBook.getInstance().getListBookAll()) {
			System.out.println(book.getName());

		}
		// OnlineBook.getInstance().exportOrderCSV("Fedosevich");
		//OnlineBook.getInstance().saveToDataBases();
	}

}
