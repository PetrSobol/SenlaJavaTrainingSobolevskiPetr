package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.client.Client;
import com.senla.sobol.di.DI;

public class ExportBookAction implements IAction {
	private static final String NAMEMETOD = "exportBookCSV";
	private EssenceCommon essence = new EssenceCommon();
	private Logger loger = Logger.getLogger(ExportBookAction.class.getName());

	/**
	 * export books list in databases
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
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
