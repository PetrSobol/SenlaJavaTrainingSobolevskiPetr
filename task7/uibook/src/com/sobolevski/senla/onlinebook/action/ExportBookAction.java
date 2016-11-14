package com.sobolevski.senla.onlinebook.action;

import controller.OnlineBook;

public class ExportBookAction implements IAction {
	/**
	 * export books list in databases
	 */
	@Override
	public void process() {
		OnlineBook.getInstance().exportBookCSV();
	}

}
