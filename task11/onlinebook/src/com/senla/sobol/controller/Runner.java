package com.senla.sobol.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.senla.sobol.di.DI;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOnlineBook;
import com.senla.sobol.model.IOrder;
import com.senla.sobol.model.IWriter;

public class Runner {

	public static void main(String[] args) {
		SimpleDateFormat simpledate = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println(simpledate.format(new Date()));

		IOnlineBook onlineBook;
		try {
			onlineBook = (IOnlineBook) DI.load(IOnlineBook.class);

		onlineBook.deleteWriter(3);
			Date date = simpledate.parse("10.10.2019");
			System.out.println(date);

			List<IWriter> listwriter = onlineBook.getListWriter();

			for (IWriter writer : listwriter) {
				System.out.println(writer.getFirstname());
			}
			System.out.println("____________________________");
			List<IWriter> listwriter2 = onlineBook.getSortWriterName();

			for (IWriter writer : listwriter2) {
				System.out.println(writer.getFirstname());
			}
			System.out.println("____________________________");
			List<IOrder> listorder = onlineBook.getListOrder();
			for (IOrder order : listorder) {
				System.out.println(simpledate.format(order.getDateOrder()) + " " + order.getCustomer().getFirstname()
						+ " " + order.getBook().getNameBook() + " " + order.getBook().getPrice());
			}
			System.out.println("________________________________");
			System.out.println("____________________________");
			List<IOrder> listorder9 = onlineBook.getSortOrderByDate();
			for (IOrder order : listorder9) {
				System.out.println(simpledate.format(order.getDateOrder()) + " " + order.getCustomer().getFirstname()
						+ " " + order.getBook().getNameBook() + " " + order.getBook().getPrice());
			}
			System.out.println("________________________________");
			List<ICustomer> listcustomer = onlineBook.getListCustomer();
			for (ICustomer customer : listcustomer) {
				System.out.println(customer.getFirstname());
			}
			System.out.println("______________________________");
			System.out.println("________________________________");
			List<ICustomer> listcustomer4 = onlineBook.getSortCustomerName();
			for (ICustomer customer : listcustomer4) {
				System.out.println(customer.getFirstname());
			}
			System.out.println("______________________________");
			List<IBook> listbook = onlineBook.getListBook();
			for (IBook book : listbook) {
				System.out.println(book.getNameBook() + " " + book.getWriter().getFirstname() + " "
						+ book.getQuantityPages() + " " + book.getPrice());
			}

			System.out.println("______________________________");
			System.out.println("______________________________");
			List<IBook> listbook6 = onlineBook.getSortBookByPrice();
			for (IBook book : listbook6) {
				System.out.println(book.getNameBook() + " " + book.getWriter().getFirstname() + " "
						+ book.getQuantityPages() + " " + book.getPrice());
			}

			System.out.println("______________________________");

			List<IBook> listbook2 = onlineBook.getSortBookByDate();
			for (IBook book : listbook2) {
				System.out.println(book.getNameBook() + " " + book.getWriter().getFirstname() + " "
						+ book.getQuantityPages() + " " + book.getPrice());
			}

			System.out.println("______________________________");

			List<IBook> listbook3 = onlineBook.getSortBookByPrice();
			for (IBook book : listbook3) {
				System.out.println(book.getNameBook() + " " + book.getWriter().getFirstname() + " "
						+ book.getQuantityPages() + " " + book.getPrice());
			}

			System.out.println("______________________________");

		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
