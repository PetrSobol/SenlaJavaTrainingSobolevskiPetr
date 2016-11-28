package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;

public class SaveBaseAction implements IAction {
	private static final String SAVEBASEACTION = "savebaseaction";

	/**
	 * save data to databases
	 */
	@Override
	public void process() {
		Client.getInstance().getWordList(SAVEBASEACTION);

	}

}
