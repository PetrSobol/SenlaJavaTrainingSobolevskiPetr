package action;

import operationmenu.SingleTonOnlineBook;

public class SortBookStage implements IAction {

	@Override
	public void process() {
		SingleTonOnlineBook.getInstance().getOnlineBook()
				.printListBook(SingleTonOnlineBook.getInstance().getOnlineBook().sortBookStage());

	}

}
