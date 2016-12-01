package com.sobolevski.senla.onlinebook.action;


import com.senla.sobol.api.EssenceCommon;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class SortBookStage implements IAction {
	private static final String NAMEMETOD = "sortBookStage";
	private Print print = new Print();
	private EssenceCommon essence=new EssenceCommon();
	/**
	 * print sort list books by stage
	 */
	@Override
	public void process() {
		essence.setNameMetod(NAMEMETOD);
		//give metod
		//print.printListBook( Client.getInstance().getWordList(SORTBOOKSTAGE));

	}

}
