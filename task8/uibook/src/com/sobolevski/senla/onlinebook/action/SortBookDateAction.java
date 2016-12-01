package com.sobolevski.senla.onlinebook.action;


import com.senla.sobol.api.EssenceCommon;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookDateAction implements IAction {
	private static final String NAMEMETOD = "sortBookDate";
	private Print print = new Print();
	private EssenceCommon essence=new EssenceCommon();
	/**
	 * print sort list books by date
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod
	//print.printListBook( Client.getInstance().getWordList(SORTBOOKDATE));
	}

}
