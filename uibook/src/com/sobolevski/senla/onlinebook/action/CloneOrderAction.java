package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.client.Client;
import com.senla.sobol.di.DI;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class CloneOrderAction implements IAction {
	private static final String NAMEMETOD = "cloneOrder";
	private static final String LASTNAME = "Lastname?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	private Logger loger = Logger.getLogger(CloneOrderAction.class.getName());

	/**
	 * clone order
	 */
	@Override
	public void process() {

		print.printMessage(LASTNAME);
		String lastname = scanerbox.getWord();
		essence.setNameMetod(NAMEMETOD);
		Object[] array = { lastname };
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
