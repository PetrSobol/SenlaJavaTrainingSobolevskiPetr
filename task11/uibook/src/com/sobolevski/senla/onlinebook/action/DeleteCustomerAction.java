package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class DeleteCustomerAction implements IAction {
	private static final String NAMEMETOD = "deleteCustomer";
	private static final String NAME_BOOK2 = "Id customer?";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = new EssenceCommon();
	/**
	 * delete book
	 */
	@Override
	public void process(SupportClient supportaction) {
		print.printMessage(NAME_BOOK2);
		Integer idbook=scanerbox.getNumber();
		essence.setNameMetod(NAMEMETOD);
		Object[] array = { idbook };
		essence.setObjects(array);
		supportaction.getEssennce(essence);
	}
}
