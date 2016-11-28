package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookStage implements IAction {
	private static final String SORTBOOKSTAGE = "sortbookstage";
	private Print print = new Print();
	/**
	 * print sort list books by stage
	 */
	@Override
	public void process() {
		print.printListBook( Client.getInstance().getWordList(SORTBOOKSTAGE));

	}

}
