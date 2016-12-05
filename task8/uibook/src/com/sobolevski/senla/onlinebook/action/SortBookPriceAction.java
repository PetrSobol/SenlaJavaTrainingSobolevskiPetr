package com.sobolevski.senla.onlinebook.action;

import java.util.List;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookPriceAction implements IAction {
	private static final String NAMEMETOD = "sortBookPrice";
	private Print print = new Print();

	/**
	 * print sirt list books by price
	 */
	@Override
	public void process(SupportClient supportaction) {
		EssenceCommon essence = new EssenceCommon();
		essence.setNameMetod(NAMEMETOD);
		EssenceCommon essenceCommon = supportaction.getEssennce(essence);
		print.printListBook((List<?>) essenceCommon.getCurront());
	}

}
