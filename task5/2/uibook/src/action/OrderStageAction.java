package action;

import operationmenu.SingleTonOnlineBook;

public class OrderStageAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListOrder(SingleTonOnlineBook.getInstance().getOnlineBook().sortOrderStage());

	}

}
