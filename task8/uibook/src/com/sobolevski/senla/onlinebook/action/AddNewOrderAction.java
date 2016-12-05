package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class AddNewOrderAction implements IAction {
	private static final String NAMEMETOD = "addOrder";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private static final String NAME_BOOK2 = "Name book?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	/**
	 * add new order in databases
	 */
	@Override
	public void process(SupportClient supportaction) {
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord();
		print.printMessage(YOUR_FIRSTNAME);
		String firstname = scanerbox.getWord();
		print.printMessage(NAME_BOOK2);
		String namebook = scanerbox.getWord();
		essence.setNameMetod(NAMEMETOD);
		Object[] a = { lastname, firstname, namebook };
		essence.setObjects(a);
		supportaction.getEssennce(essence);

	}

}
