package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;
import di.DI;
import interfaces.IOnlineBook;

public class ImportOrderAction implements IAction {
	private Logger log = Logger.getLogger(ImportOrderAction.class.getName());

	/**
	 * import orders list in CSV
	 */
	@Override
	public void process() {
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			onlinebook.importOrderCSV();
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}
}
