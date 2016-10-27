package action;

import operationmenu.SingleTonOnlineBook;

public class SortBookPriceAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListBook(SingleTonOnlineBook.getInstance().getOnlineBook().sortBookPrice());

	}

}
