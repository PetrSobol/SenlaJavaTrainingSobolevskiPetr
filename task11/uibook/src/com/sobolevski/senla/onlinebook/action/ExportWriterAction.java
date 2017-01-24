package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;

public class ExportWriterAction implements IAction {
	private static final String NAMEMETOD = "exportWriterCSV";
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * import list books in CSV
	 */
	@Override
	public void process(SupportClient supportaction) {
		essence.setNameMetod(NAMEMETOD);
		supportaction.getEssennce(essence);
	}

}
