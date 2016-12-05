package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class AddNewBookAction implements IAction {
	private static final String NAMEMETOD = "addNewBook";
	private static final String OPERATION_FINISH_SUCESS = "Operation finish sucess";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String NAME_BOOK2 = "Name book?";
	private static final String WRITER_BOOK = "Writer book?";
	private static final String PRICE = "Price?";
	private static final String YEAR_YYYY = "Year? #yyyy#";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * add new book in databases
	 */

	@Override
	public void process(SupportClient supportaction) {
		print.printMessage(NAME_BOOK2);
		String name = scanerbox.getWord();
		print.printMessage(WRITER_BOOK);
		String writer = scanerbox.getWord();
		print.printMessage(PRICE);
		Integer price = scanerbox.getNumber();
		print.printMessage(YEAR_YYYY);
		Integer quantity = scanerbox.getNumber();
		if (name != null && writer != null && price != null && quantity != null) {
			essence.setNameMetod(NAMEMETOD);
			Object[] arraystring = { name, writer, price, quantity };
			essence.setObjects(arraystring);
			supportaction.getEssennce(essence);
			print.printMessage(OPERATION_FINISH_SUCESS);
		} else {
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);

		}
	}
}
