package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import di.DI;
import interfaces.IOnlineBook;

public class CloneOrderAction implements IAction {
	private static final String LASTNAME = "Lastname?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private Logger log = Logger.getLogger(AddNewOrderAction.class.getName());

	/**
	 * clone order
	 */
	@Override
	public void process() {
		print.printMessage(LASTNAME);
		String lastname = scanerbox.getWord();
		try {
			IOnlineBook onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			onlinebook.cloneOrder(lastname);
		} catch (CloneNotSupportedException e) {
			log.error(e);
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
