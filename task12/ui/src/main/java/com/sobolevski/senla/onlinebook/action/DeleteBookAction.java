package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class DeleteBookAction implements IAction {
	private static final String NAMEMETOD = "deleteBook";
	private static final String NAME_BOOK2 = "Id book?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = null;
	/**
	 * delete book
	 */
	public void process(SupportClient supportaction) {
		essence=new EssenceCommon();
		print.printMessage(NAME_BOOK2);
		Integer idbook=scanerbox.getNumber();
		essence.setNameMetod(NAMEMETOD);
		Object[] array = { idbook };
		essence.setObjects(array);
		supportaction.getEssennce(essence);
	}
}
