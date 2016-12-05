package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;

public class ExportOrderAction implements IAction {
	private static final String NAMEMETOD = "exportOrderCSV";
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * export list order in databases
	 */
	@Override
	public void process(SupportClient supportaction) {
		essence.setNameMetod(NAMEMETOD);
		supportaction.getEssennce(essence);
	}
}
