package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class AddNewOrderAction implements IAction {
	private static final String ID_BOOK = "id Book?";
	private static final String ID_CUSTOMER = "id Customer?";
	private static final String NAMEMETOD = "addNewOrder";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private EssenceCommon essence = null;
	/**
	 * add new order in databases
	 */

	public void process(SupportClient supportaction) {
		essence=new EssenceCommon();
		print.printMessage(ID_CUSTOMER);
		Integer idcustomer=scanerbox.getNumber();
		print.printMessage(ID_BOOK);
		Integer idbook=scanerbox.getNumber();
		essence.setNameMetod(NAMEMETOD);
		Object[] a = { idcustomer, idbook};
		essence.setObjects(a);
		supportaction.getEssennce(essence);

	}

}
