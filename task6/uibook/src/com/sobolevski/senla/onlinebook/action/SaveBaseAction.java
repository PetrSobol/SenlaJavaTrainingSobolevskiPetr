package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import controller.OnlineBook;

public class SaveBaseAction implements IAction {
	private Logger log = Logger.getLogger(SaveBaseAction.class.getName());

	/**
	 * save data to databases
	 */
	@Override
	public void process() {
		OnlineBook.getInstance().saveToDataBases();
		log.info("save to databases");

	}

}
