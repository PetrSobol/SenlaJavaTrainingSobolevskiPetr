package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookPriceAction implements IAction {
	private static final String NAMEMETOD = "sortBookPrice";
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * print sirt list books by price
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod
		// print.printListBook(
		// Client.getInstance().getWordList(SORTBOOKPRICE));

	}

}
