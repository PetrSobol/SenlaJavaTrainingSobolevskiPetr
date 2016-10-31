package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class PrintOrderActionAll implements IAction {

	@Override
	public void process() {
		
			SingleTonOnlineBook.getInstance().getOnlineBook().printOrderAll();
		
		
	}

}
