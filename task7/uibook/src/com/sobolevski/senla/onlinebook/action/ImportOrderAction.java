package com.sobolevski.senla.onlinebook.action;

import controller.OnlineBook;

public class ImportOrderAction implements IAction {
	/**
	 * import orders list in CSV
	 */
	@Override
	public void process() {
		OnlineBook.getInstance().importOrderCSV();

	}
}
