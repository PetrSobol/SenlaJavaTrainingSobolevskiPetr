package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import controller.OnlineBook;

public class PrintBookActionAll implements IAction {
	private Print print = new Print();

	/**
	 * print list all books
	 */
	@Override
	public void process() {
		print.printListBook(OnlineBook.getInstance().getListBookAll());
	}

}
