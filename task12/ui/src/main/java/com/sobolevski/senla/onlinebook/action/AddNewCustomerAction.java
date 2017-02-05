package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class AddNewCustomerAction implements IAction{

	private static final String YOUR_PHONE = "Your phone?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String NAMEMETOD = "addNewCustomer";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	/**
	 * add new order in databases
	 */

	public void process(SupportClient supportaction) {
		print.printMessage(YOUR_LASTNAME);
		String lastname=scanerbox.getWord();
		print.printMessage(YOUR_FIRSTNAME);
		String firatname=scanerbox.getWord();
		print.printMessage(YOUR_PHONE);
		Integer phone=scanerbox.getNumber();
		essence.setNameMetod(NAMEMETOD);
		Object[] a = { lastname, firatname,phone};
		essence.setObjects(a);
		supportaction.getEssennce(essence);

	}

}
