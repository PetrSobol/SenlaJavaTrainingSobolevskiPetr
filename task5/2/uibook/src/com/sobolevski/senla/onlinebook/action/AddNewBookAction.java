package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class AddNewBookAction implements IAction {
	private static final String BOOK_ADD_SUCESS = "Book add sucess";
	private Scanner scaner;

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		System.out.println("Name book?");
		String name = scaner.nextLine();
		System.out.println("Writer book?");
		String writer = scaner.nextLine();
		System.out.println("Price?");
		Integer price = Integer.parseInt(scaner.nextLine());
		System.out.println("Year? #yyyy#");
		Integer quantity = Integer.parseInt(scaner.nextLine());
		SingleTonOnlineBook.getInstance().getOnlineBook().addNewBook(name, writer, price, quantity);
		System.out.println(BOOK_ADD_SUCESS);
	}

}
