package com.sobolevski.senla.onlinebook.action;

import java.util.List;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookPriceAction implements IAction{
	private static final String NAMEMETOD = "getSortBookByPrice";
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * print sort list books by date
	 */
	public void process(SupportClient supportaction) {
		essence.setNameMetod(NAMEMETOD);
		EssenceCommon essenceCommon=supportaction.getEssennce(essence);
		print.printListBook((List<?>) essenceCommon.getCurront());
		}
}
