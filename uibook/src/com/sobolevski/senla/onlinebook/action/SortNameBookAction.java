package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortNameBookAction implements IAction {
	private static final String NAMEMETOD = "sortBookName";
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * print sort list book by name
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod
		// print.printListBook( Client.getInstance().getWordList(SORTBOOKNAME));
	}

}
