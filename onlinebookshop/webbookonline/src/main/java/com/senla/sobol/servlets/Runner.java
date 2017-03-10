package com.senla.sobol.servlets;

import java.util.List;

import com.senla.sobol.di.DI;
import com.senla.sobol.intarfaces.IOnlineBook;
import com.senla.sobol.model.Book;
import com.senla.sobol.model.Customer;
import com.senla.sobol.model.Orders;
import com.senla.sobol.model.Writer;

public class Runner {

	public static void main(String[] args) {
		try {
			IOnlineBook onlineBook =(IOnlineBook) DI.load(IOnlineBook.class);
		//	Integer number=onlineBook.getOrderPriceByCustomer(2);
			//System.out.println(number);
			/*List<Orders> listorders4 = onlineBook.getListOrderByIdCustomer(2);
			for (Orders orders : listorders4) {
				System.out.println(
						orders.getBook().getNameBook() + orders.getCustomer().getFirstname() + orders.getDateOrder());
			}
			System.out.println("____________________________________________________");*/
			List<Book> listbook = onlineBook.getListBook();
	

			for (Book book : listbook) {
				System.out.println(book.getNameBook() + book.getWriter().getFirstname());
			}
			System.out.println("_______________________________________________________");
			List<Book> listbook4 = onlineBook.getSortBookByName();

			for (Book book : listbook4) {
				System.out.println(book.getNameBook() + book.getWriter().getFirstname() + book.getPrice());
			}
			System.out.println("________________________________________________________");
			System.out.println("_______________________________________________________");
			List<Book> listbook3 = onlineBook.getSortBookByPrice();

			for (Book book : listbook3) {
				System.out.println(book.getNameBook() + book.getWriter().getFirstname() + book.getPrice());
			}
			System.out.println("________________________________________________________");
			List<Orders> listorders = onlineBook.getListOrder();
			for (Orders orders : listorders) {
				System.out.println(
						orders.getBook().getNameBook() + orders.getCustomer().getFirstname() + orders.getDateOrder());
			}
			System.out.println("____________________________________________________");
			List<Orders> listorders2 = onlineBook.getSortOrderByDate();
			for (Orders orders : listorders2) {
				System.out.println(
						orders.getBook().getNameBook() + orders.getCustomer().getFirstname() + orders.getDateOrder());
			}
			System.out.println("____________________________________________________");
			List<Customer> listcustomer = onlineBook.getListCustomer();
			for (Customer customer : listcustomer) {
				System.out.println(customer.getFirstname());
			}
			System.out.println("_____________________________________");
			System.out.println("____________________________________________________");
			List<Customer> listcustomer6 = onlineBook.getSortCustomerName();
			for (Customer customer : listcustomer6) {
				System.out.println(customer.getFirstname());
			}
			System.out.println("_____________________________________");
			List<Writer> listwriter = onlineBook.getListWriter();
			for (Writer writer : listwriter) {
				System.out.println(writer.getDiedYear() + writer.getFirstname());
			}
			System.out.println("_____________________________________");
			List<Writer> listwriter2 = onlineBook.getSortWriterName();
			for (Writer writer : listwriter2) {
				System.out.println(writer.getDiedYear() + writer.getFirstname());
			}
		}  catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
