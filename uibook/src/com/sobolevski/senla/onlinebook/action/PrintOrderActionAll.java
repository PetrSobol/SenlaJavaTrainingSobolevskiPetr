package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintOrderActionAll implements IAction {
	private static final String ORDERALL = "orderall";
	private Print print = new Print();
	/**orderall
	 * print list all orders
	 */
	@Override
	public void process() {
		print.printListOrder( Client.getInstance().getWordList(ORDERALL));

	}

}
