package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import di.DI;
import interfaces.IOnlineBook;

public class SortNameBookAction implements IAction {
	private Print print = new Print();
	private Logger log = Logger.getLogger(SortNameBookAction.class.getName());

	/**
	 * print sort list book by name
	 */
	@Override
	public void process() {
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			print.printListBook(onlinebook.sortBookName());
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
