package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import di.DI;
import interfaces.IOnlineBook;

public class SortBookStage implements IAction {
	private Print print = new Print();
	private Logger log = Logger.getLogger(SortBookStage.class.getName());

	/**
	 * print sort list books by stage
	 */
	@Override
	public void process() {
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			print.printListBook(onlinebook.sortBookStage());
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
