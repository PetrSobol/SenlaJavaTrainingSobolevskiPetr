package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

import di.DI;
import interfaces.IOnlineBook;

public class SortOrderPriceAction implements IAction {
	private Print print = new Print();
	private Logger log = Logger.getLogger(SortOrderPriceAction.class.getName());

	/**
	 * print sort list orders by price
	 */
	@Override
	public void process() {
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			print.printListOrder(onlinebook.sortOrderPrice());
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
