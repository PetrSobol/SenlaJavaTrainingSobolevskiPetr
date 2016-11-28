package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookPriceAction implements IAction {
	private static final String SORTBOOKPRICE = "sortbookprice";
	private Print print = new Print();
	/**
	 * print sirt list books by price
	 */
	@Override
	public void process() {
		print.printListBook( Client.getInstance().getWordList(SORTBOOKPRICE));

	}

}
