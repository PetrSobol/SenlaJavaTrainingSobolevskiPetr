package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.client.Client;
import com.senla.sobol.di.DI;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class DeleteBookAction implements IAction {
	private static final String NAMEMETOD = "deleteBook";
	private static final String NAME_BOOK2 = "Name book?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = new EssenceCommon();
	private Logger loger = Logger.getLogger(DeleteBookAction.class.getName());

	/**
	 * delete book
	 */
	@Override
	public void process() {
		print.printMessage(NAME_BOOK2);
		String name = scanerbox.getWord();
		essence.setNameMetod(NAMEMETOD);
		Object[] array = { name };
		essence.setObjects(array);
		Client client;
		try {
			client = (Client) DI.load(Client.class);
			client.getEssennce(essence);
		} catch (InstantiationException e) {
			loger.error(e);
		} catch (IllegalAccessException e) {
			loger.error(e);
		} catch (ClassNotFoundException e) {
			loger.error(e);
		}

	}

}
