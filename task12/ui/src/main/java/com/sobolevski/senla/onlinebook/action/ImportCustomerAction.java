package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;

public class ImportCustomerAction implements IAction {
	private static final String NAMEMETOD = "importCustomerCSV";
	private EssenceCommon essence = null;

	/**
	 * import list books in CSV
	 */
	public void process(SupportClient supportaction) {
		essence = new EssenceCommon();
		essence.setNameMetod(NAMEMETOD);
		supportaction.getEssennce(essence);
	}
}
