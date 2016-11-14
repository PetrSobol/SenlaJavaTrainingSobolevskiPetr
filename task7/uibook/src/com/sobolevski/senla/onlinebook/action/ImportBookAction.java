package com.sobolevski.senla.onlinebook.action;

import controller.OnlineBook;

public class ImportBookAction implements IAction {
	/**
	 * import list books in CSV
	 */
	@Override
	public void process() {
		OnlineBook.getInstance().importBookCSV();

	}

}
