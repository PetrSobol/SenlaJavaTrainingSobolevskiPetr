package com.sobolevski.senla.onlinebook.action;

import java.util.List;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

import model.Book;

public class PrintBookActionAll implements IAction {
	private Print print = new Print();
	/**
	 * print list all books
	 */
	@Override
	public void process() {
		print.printListBook((List<Book>) Client.getInstance().getWordList("bookall"));
	

	}

}
