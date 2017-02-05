package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class DeleteOrderAction implements IAction {
	private static final String ID_ORDER = "ID order?";
	private static final String NAMEMETOD = "deleteOrder";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * delete book
	 */
	public void process(SupportClient supportaction) {
		print.printMessage(ID_ORDER);
		Integer idorder = scanerbox.getNumber();
		essence.setNameMetod(NAMEMETOD);
		Object[] array = { idorder };
		essence.setObjects(array);
		supportaction.getEssennce(essence);
	}
}
