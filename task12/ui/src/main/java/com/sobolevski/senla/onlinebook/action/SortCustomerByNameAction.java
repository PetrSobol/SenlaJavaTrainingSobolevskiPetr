package com.sobolevski.senla.onlinebook.action;

import java.util.List;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortCustomerByNameAction implements IAction {
	private static final String NAMEMETOD = "getSortCustomerName";
	private Print print = new Print();
	private EssenceCommon essence = null;

	/**
	 * print sort list books by date
	 */
	public void process(SupportClient supportaction) {
		essence = new EssenceCommon();
		essence.setNameMetod(NAMEMETOD);
		EssenceCommon essenceCommon = supportaction.getEssennce(essence);
		print.printListCustomer((List<?>) essenceCommon.getCurront());
	}
}
