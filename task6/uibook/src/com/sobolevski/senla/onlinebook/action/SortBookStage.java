package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import controller.OnlineBook;

public class SortBookStage implements IAction {
	private Print print = new Print();

	/**
	 * print sort list books by stage
	 */
	@Override
	public void process() {
		print.printListBook(OnlineBook.getInstance().sortBookStage());
	}

}
