package com.sobolevski.senla.onlinebook.action;

import controller.OnlineBook;

public class ImportOrderAction implements IAction {
	@Override
	public void process() {
		OnlineBook.getInstance().importOrderCSV();
		
	}
}
