package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortNameBookAction implements IAction {
	private static final String SORTBOOKNAME = "sortbookname";
	private Print print = new Print();
	/**
	 * print sort list book by name
	 */
	@Override
	public void process() {
		print.printListBook( Client.getInstance().getWordList(SORTBOOKNAME));
	}

}
