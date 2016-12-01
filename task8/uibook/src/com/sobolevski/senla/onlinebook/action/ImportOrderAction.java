package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;

public class ImportOrderAction implements IAction {
	private static final String NAMEMETOD = "importOrderCSV";
	private EssenceCommon essence=new EssenceCommon();
	/**
	 * import orders list in CSV
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod

	}
}
