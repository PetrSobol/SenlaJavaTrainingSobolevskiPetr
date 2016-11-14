package com.sobolevski.senla.onlinebook.action;

import controller.OnlineBook;

public class ExportOrderAction implements IAction {
	/**
	 * export list order in databases
	 */
	@Override
	public void process() {
		OnlineBook.getInstance().exportOrderCSV();
	}
}
