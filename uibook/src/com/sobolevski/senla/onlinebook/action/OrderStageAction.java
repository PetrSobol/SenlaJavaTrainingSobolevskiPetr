package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class OrderStageAction implements IAction {
	private static final String SORTORDERSTAGE = "sortorderstage";
	private Print print = new Print();


	/**
	 * print sort order by stage
	 */
	@Override
	public void process() {
		print.printListOrder( Client.getInstance().getWordList(SORTORDERSTAGE));

	}

}
