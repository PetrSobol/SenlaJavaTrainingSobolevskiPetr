package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.client.Client;
import com.senla.sobol.di.DI;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class AddNewOrderAction implements IAction {
	private static final String NAMEMETOD = "addOrder";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private static final String NAME_BOOK2 = "Name book?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	private Logger loger = Logger.getLogger(AddNewOrderAction.class.getName());

	/**
	 * add new order in databases
	 */
	@Override
	public void process() {
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord();
		print.printMessage(YOUR_FIRSTNAME);
		String firstname = scanerbox.getWord();
		print.printMessage(NAME_BOOK2);
		String namebook = scanerbox.getWord();
		essence.setNameMetod(NAMEMETOD);
		Object[] a = { lastname, firstname, namebook };
		essence.setObjects(a);
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
