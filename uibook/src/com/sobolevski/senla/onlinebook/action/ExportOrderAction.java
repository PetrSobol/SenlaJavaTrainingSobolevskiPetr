package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import di.DI;
import interfaces.IOnlineBook;

public class ExportOrderAction implements IAction {
	private Logger log = Logger.getLogger(ExportOrderAction.class.getName());

	/**
	 * export list order in databases
	 */
	@Override
	public void process() {
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			onlinebook.exportOrderCSV();
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}
}
