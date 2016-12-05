package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;

public class ImportOrderAction implements IAction {
	private static final String NAMEMETOD = "importOrderCSV";
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * import orders list in CSV
	 */
	@Override
	public void process(SupportClient supportaction) {
		essence.setNameMetod(NAMEMETOD);
		supportaction.getEssennce(essence);

	}
}
