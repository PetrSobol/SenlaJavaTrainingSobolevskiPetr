package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;

public class ExportOrderAction implements IAction {
	private static final String NAMEMETOD = "exportOrderCSV";
	private EssenceCommon essence = null;

	/**
	 * export list order in databases
	 */
	public void process(SupportClient supportaction) {
		essence = new EssenceCommon();
		essence.setNameMetod(NAMEMETOD);
		supportaction.getEssennce(essence);
	}
}
