package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import di.DI;
import interfaces.IOnlineBook;

public class DeleteBookAction implements IAction {
	private static final String NAME_BOOK2 = "Name book?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Logger log = Logger.getLogger(DeleteBookAction.class.getName());

	/**
	 * delete book
	 */
	@Override
	public void process() {
		print.printMessage(NAME_BOOK2);
		String name = scanerbox.getWord();
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			onlinebook.deleteBook(name);
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
