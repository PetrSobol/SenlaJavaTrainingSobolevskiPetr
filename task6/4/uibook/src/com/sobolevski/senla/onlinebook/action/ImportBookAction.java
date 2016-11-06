package com.sobolevski.senla.onlinebook.action;

import controller.OnlineBook;

public class ImportBookAction implements IAction {

	@Override
	public void process() {
		OnlineBook.getInstance().importBookCSV();
		
	}

}
