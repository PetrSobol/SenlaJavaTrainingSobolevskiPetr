package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;

public class ExportBookAction implements IAction {
	private static final String NAMEMETOD = "exportBookCSV";
	private EssenceCommon essence = new EssenceCommon();
	/**
	 * export books list in databases
	 */
	public void process(SupportClient supportaction) {
		essence.setNameMetod(NAMEMETOD);
		supportaction.getEssennce(essence);
	

	}

}
