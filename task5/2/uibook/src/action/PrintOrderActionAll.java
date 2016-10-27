package action;

import operationmenu.SingleTonOnlineBook;

public class PrintOrderActionAll implements IAction {

	@Override
	public void process() {
		
			SingleTonOnlineBook.getInstance().getOnlineBook().printOrderAll();
		
		
	}

}
