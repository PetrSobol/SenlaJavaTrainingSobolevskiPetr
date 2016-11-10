package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class DeleteBookAction implements IAction {
	private static final String NAME_BOOK2 = "Name book?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();

	/**
	 * delete book
	 */
	@Override
	public void process() {
		print.printMessage(NAME_BOOK2);
		String name = scanerbox.getWord();
		OnlineBook.getInstance().deleteBook(name);

	}

}
