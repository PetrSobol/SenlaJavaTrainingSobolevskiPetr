package com.sobolevski.senla.onlinebook.action;

import loger.WriteLoger;
import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class SaveBaseAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook().saveToDataBases();
		WriteLoger.getLogger(SaveBaseAction.class.getName()).info("Save to database");
		
	}

}
