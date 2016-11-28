package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookDateAction implements IAction {
	private static final String SORTBOOKDATE = "sortbookdate";
	private Print print = new Print();
	/**
	 * print sort list books by date
	 */
	@Override
	public void process() {
		print.printListBook( Client.getInstance().getWordList(SORTBOOKDATE));
	}

}
