package action;

import operationmenu.SingleTonOnlineBook;

public class SortBookDateAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListBook(SingleTonOnlineBook.getInstance().getOnlineBook().sortBookDate());

	}

}
