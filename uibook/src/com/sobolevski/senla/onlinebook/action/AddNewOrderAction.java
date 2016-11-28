package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class AddNewOrderAction implements IAction {
	private static final String ADDNEWORDER = "addneworder";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private static final String NAME_BOOK2 = "Name book?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private StringBuilder string=new StringBuilder();

	/**
	 * add new order in databases
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
		string.append(",");
		print.printMessage(NAME_BOOK2);
		String namebook = scanerbox.getWord();
		string.append(namebook);
		Client.getInstance().setDateToServer(ADDNEWORDER, string.toString());
	}

}
