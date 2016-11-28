package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortOrderPriceAction implements IAction {
	private static final String SORTORDERPRICE = "sortorderprice";
	private Print print = new Print();
	

	/**
	 * print sort list orders by price
	 */
	@Override
	public void process() {
		print.printListOrder( Client.getInstance().getWordList(SORTORDERPRICE));

	}

}
