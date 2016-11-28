package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class CloneOrderAction implements IAction {
	private static final String CLONEORDER = "cloneorder";
	private static final String LASTNAME = "Lastname?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private StringBuilder string=new StringBuilder();

	/**
	 * clone order
	 */
	@Override
	public void process() {
		print.printMessage(LASTNAME);
		String lastname = scanerbox.getWord();
		string.append(lastname);
		Client.getInstance().setDateToServer(CLONEORDER, string.toString());
	}

}
