package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.client.Client;
import com.senla.sobol.di.DI;
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
	private Logger loger = Logger.getLogger(AddNewBookAction.class.getName());

	/**
	 * add new book in databases
	 */

	@Override
	public void process() {

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
			Client client;
			try {
				client = (Client) DI.load(Client.class);
				client.getEssennce(essence);
				print.printMessage(OPERATION_FINISH_SUCESS);
			} catch (InstantiationException e) {
				loger.error(e);
			} catch (IllegalAccessException e) {
				loger.error(e);
			} catch (ClassNotFoundException e) {
				loger.error(e);
			}

		} else {
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);

		}
	}
}
