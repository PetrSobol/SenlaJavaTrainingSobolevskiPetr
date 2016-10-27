package action;

import operationmenu.SingleTonOnlineBook;

public class SortNameBookAction implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListBook(SingleTonOnlineBook.getInstance().getOnlineBook().sortBookName());

	}

}
