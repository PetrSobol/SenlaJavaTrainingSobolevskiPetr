package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;

public class ExportBookAction implements IAction {
	private static final String EXPORTBOOK = "exportbook";
	/**
	 * export books list in databases
	 */
	@Override
	public void process() {
		Client.getInstance().goWord(EXPORTBOOK);

	}

}
