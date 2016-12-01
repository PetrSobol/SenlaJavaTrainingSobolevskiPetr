package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.client.Client;
import com.senla.sobol.di.DI;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintBookActionAll implements IAction {
	private static final String NAMEMETOD = "getListBookAll";
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	private Logger loger = Logger.getLogger(PrintBookActionAll.class.getName());

	/**
	 * print list all books
	 */
	@Override
	public void process() {
		Client client;
		try {
			client = (Client) DI.load(Client.class);
			essence.setNameMetod(NAMEMETOD);
			EssenceCommon essence2 = client.getEssennce(essence);
			print.printListBook(essence2.getLsit());
		} catch (InstantiationException e) {
			loger.error(e);
		} catch (IllegalAccessException e) {
			loger.error(e);
		} catch (ClassNotFoundException e) {
			loger.error(e);
		}

	}

}
