package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;

public class SaveBaseAction implements IAction {
	private static final String NAMEMETOD = "saveToDataBases";
	private EssenceCommon essence=new EssenceCommon();
	/**
	 * save data to databases
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod
		//Client.getInstance().getWordList(SAVEBASEACTION);

	}

}
