package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class DeleteBookAction implements IAction {
	private static final String DELETEBOOK = "deletebook";
	private static final String NAME_BOOK2 = "Name book?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private StringBuilder string=new StringBuilder();

	/**
	 * delete book
	 */
	@Override
	public void process() {
		print.printMessage(NAME_BOOK2);
		String name = scanerbox.getWord();
		string.append(name);
		Client.getInstance().setDateToServer(DELETEBOOK, string.toString());
	}

}
