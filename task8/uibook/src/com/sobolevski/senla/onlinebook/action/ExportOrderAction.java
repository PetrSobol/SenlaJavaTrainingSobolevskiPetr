package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;

public class ExportOrderAction implements IAction {
	private static final String NAMEMETOD = "exportOrderCSV";
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * export list order in databases
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		// give metod
	}
}
