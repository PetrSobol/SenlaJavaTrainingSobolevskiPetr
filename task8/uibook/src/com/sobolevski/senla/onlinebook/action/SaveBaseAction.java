package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;

public class SaveBaseAction implements IAction {
	private static final String NAMEMETOD = "saveToDataBases";
	private EssenceCommon essence=new EssenceCommon();
	/**
	 * save data to databases
	 */
	@Override
	public void process(SupportClient supportaction) {
		essence.setNameMetod(NAMEMETOD);
		supportaction.getEssennce(essence);
		}

}
