package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import di.DI;
import interfaces.IOnlineBook;

public class SaveBaseAction implements IAction {
	private Logger log = Logger.getLogger(SaveBaseAction.class.getName());

	/**
	 * save data to databases
	 */
	@Override
	public void process() {
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			onlinebook.saveToDataBases();
			log.info("save to databases");
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
