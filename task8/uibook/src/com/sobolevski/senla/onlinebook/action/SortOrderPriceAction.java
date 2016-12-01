package com.sobolevski.senla.onlinebook.action;


import com.senla.sobol.api.EssenceCommon;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortOrderPriceAction implements IAction {
	private static final String NAMEMETOD = "sortOrderPrice";
	private Print print = new Print();
	private EssenceCommon essence=new EssenceCommon();

	/**
	 * print sort list orders by price
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod
		//print.printListOrder( Client.getInstance().getWordList(SORTORDERPRICE));

	}

}
