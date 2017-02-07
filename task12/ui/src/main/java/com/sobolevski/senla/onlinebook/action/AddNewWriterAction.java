package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class AddNewWriterAction implements IAction {
	private static final String DONT_NO_FOTMAT_DATE = "Dont no fotmat date!!!";
	private static final String DATE_DIED_DD_MM_YYYY = "Date died? #dd.MM.yyyy# ";
	private static final String DATE_START_DD_MM_YYYY = "Date start? #dd.MM.yyyy#";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String NAMEMETOD = "addNewWriter";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private EssenceCommon essence = null;

	/**
	 * add new order in databases
	 */

	public void process(SupportClient supportaction) {
		essence = new EssenceCommon();
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord();
		print.printMessage(YOUR_FIRSTNAME);
		String firatname = scanerbox.getWord();
		print.printMessage(DATE_START_DD_MM_YYYY);
		String date1 = scanerbox.dateFormat();
		print.printMessage(DATE_DIED_DD_MM_YYYY);
		String date2 = scanerbox.dateFormat();

		if (date1 != null && date2 != null) {
			essence.setNameMetod(NAMEMETOD);
			Object[] a = { lastname, firatname, date1, date2 };
			essence.setObjects(a);
			supportaction.getEssennce(essence);
		} else {
			print.printMessage(DONT_NO_FOTMAT_DATE);
		}

	}
}
