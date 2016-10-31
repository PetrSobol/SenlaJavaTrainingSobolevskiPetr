package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class OrderStageAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListOrder(SingleTonOnlineBook.getInstance().getOnlineBook().sortOrderStage());

	}

}
