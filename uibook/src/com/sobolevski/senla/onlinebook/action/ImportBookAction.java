package com.sobolevski.senla.onlinebook.action;
import com.sobolevski.senla.onlinebook.client.Client;

public class ImportBookAction implements IAction {

	private static final String IMPORTBOOK = "importbook";

	/**
	 * import list books in CSV
	 */
	@Override
	public void process() {
		Client.getInstance().goWord(IMPORTBOOK);

	}

}
