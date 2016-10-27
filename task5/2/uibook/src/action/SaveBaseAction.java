package action;

import operationmenu.SingleTonOnlineBook;

public class SaveBaseAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook().saveToDataBases();
		System.out.println("Save sucess");
		
	}

}
