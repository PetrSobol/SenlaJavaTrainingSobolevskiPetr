package action;

import operationmenu.SingleTonOnlineBook;

public class PrintBookActionAll implements IAction {

	@Override
	public void process() {

		SingleTonOnlineBook.getInstance().getOnlineBook().printBookAll();

	}

}
