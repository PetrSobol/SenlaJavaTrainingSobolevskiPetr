package com.sobolevski.senla.onlinebook.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class AddNewOrderAction implements IAction {
	private static final String OPERATION_FINISH_SUCESS = "Operation finish sucess";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private static final String NAME_BOOK2 = "Name book?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private Logger log = Logger.getLogger(AddNewOrderAction.class.getName());

	/**
	 * add new order in databases
	 */
	@Override
	public void process() {
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord();
		print.printMessage(YOUR_FIRSTNAME);
		String firstname = scanerbox.getWord();
		print.printMessage(NAME_BOOK2);
		String namebook = scanerbox.getWord();
		try {
			if (OnlineBook.getInstance().addOrder(lastname, firstname, namebook)) {
				print.printMessage(OPERATION_FINISH_SUCESS);
			} else {
				print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
			}
		} catch (ParseException e) {
			log.error(e);
		}
	}

}
