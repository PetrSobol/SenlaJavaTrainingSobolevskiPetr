package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;

public class ImportBookAction implements IAction {

	private static final String NAMEMETOD = "importBookCSV";
	private EssenceCommon essence=new EssenceCommon();
	/**
	 * import list books in CSV
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod
			}

}
