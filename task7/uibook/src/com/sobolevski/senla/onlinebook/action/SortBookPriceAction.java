package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import controller.OnlineBook;

public class SortBookPriceAction implements IAction {
	private Print print = new Print();

	/**
	 * print sirt list books by price
	 */
	@Override
	public void process() {
		print.printListBook(OnlineBook.getInstance().sortBookPrice());

	}

}
