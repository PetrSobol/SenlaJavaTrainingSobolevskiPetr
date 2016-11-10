package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class CloseOrderAction implements IAction {
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();

	/**
	 * close order in databases
	 */
	@Override
	public void process() {
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord();
		print.printMessage(YOUR_FIRSTNAME);
		String firstname = scanerbox.getWord();
		OnlineBook.getInstance().closeOrder(lastname, firstname);
	}

}
