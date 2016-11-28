package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;

public class ImportOrderAction implements IAction {
	private static final String IMPORTORDER = "importorder";
	/**
	 * import orders list in CSV
	 */
	@Override
	public void process() {
		Client.getInstance().goWord(IMPORTORDER);

	}
}
