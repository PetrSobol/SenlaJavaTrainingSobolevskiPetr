package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class CloseOrderAction implements IAction {
	private static final String CLOSEORDER = "closeorder";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private StringBuilder string=new StringBuilder();

	/**
	 * close order in databases
	 */
	@Override
	public void process() {
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord();
		string.append(lastname);
		string.append(",");
		print.printMessage(YOUR_FIRSTNAME);
		String firstname = scanerbox.getWord();
		string.append(firstname);
		Client.getInstance().setDateToServer(CLOSEORDER, string.toString());

	}

}
