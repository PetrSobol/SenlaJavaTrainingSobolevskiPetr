package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class DeleteBookAction implements IAction {
	private Scanner scanner;

	@Override
	public void process() {
		scanner = new Scanner(System.in);
		System.out.println("Name book delete?");
		String name = scanner.nextLine();

		SingleTonOnlineBook.getInstance().getOnlineBook().deleteBook(name);

	}

}
