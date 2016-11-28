package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;

public class ExportOrderAction implements IAction {
	private static final String EXPORTORDER = "exportorder";

	/**
	 * export list order in databases
	 */
	@Override
	public void process() {
		Client.getInstance().goWord(EXPORTORDER);
	}
}
