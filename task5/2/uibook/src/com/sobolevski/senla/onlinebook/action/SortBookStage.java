package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class SortBookStage implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListBook(SingleTonOnlineBook.getInstance().getOnlineBook().sortBookStage());

	}

}