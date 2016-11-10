package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import controller.OnlineBook;

public class OrderStageAction implements IAction {
	private Print print = new Print();

	/**
	 * print sort order by stage
	 */
	@Override
	public void process() {
		print.printListOrder(OnlineBook.getInstance().sortOrderStage());

	}

}
