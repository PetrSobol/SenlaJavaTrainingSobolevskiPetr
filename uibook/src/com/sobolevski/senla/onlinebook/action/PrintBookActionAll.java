package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintBookActionAll implements IAction {
	private static final String BOOKALL = "bookall";
	private Print print = new Print();
	/**
	 * print list all books
	 */
	@Override
	public void process() {
		print.printListBook( Client.getInstance().getWordList(BOOKALL));
	

	}

}
