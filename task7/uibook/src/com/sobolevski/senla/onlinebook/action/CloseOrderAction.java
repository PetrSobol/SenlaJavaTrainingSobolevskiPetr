package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import di.DI;
import interfaces.IOnlineBook;

public class CloseOrderAction implements IAction {
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Logger log = Logger.getLogger(CloseOrderAction.class.getName());

	/**
	 * close order in databases
	 */
	@Override
	public void process() {
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord();
		print.printMessage(YOUR_FIRSTNAME);
		String firstname = scanerbox.getWord();
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			onlinebook.closeOrder(lastname, firstname);
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
