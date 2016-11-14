package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import controller.OnlineBook;

public class PrintOrderActionAll implements IAction {
	private Print print = new Print();

	/**
	 * print list all orders
	 */
	@Override
	public void process() {
		print.printListOrder(OnlineBook.getInstance().getListOrderAll());

	}

}
