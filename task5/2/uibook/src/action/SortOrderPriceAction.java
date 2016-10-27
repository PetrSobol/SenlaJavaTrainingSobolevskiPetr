package action;

import operationmenu.SingleTonOnlineBook;

public class SortOrderPriceAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListOrder(SingleTonOnlineBook.getInstance().getOnlineBook().sortOrderPrice());

	}

}
