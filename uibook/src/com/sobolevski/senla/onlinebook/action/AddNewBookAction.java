package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import di.DI;
import interfaces.IOnlineBook;

public class AddNewBookAction implements IAction {
	private static final String OPERATION_FINISH_SUCESS = "Operation finish sucess";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String NAME_BOOK2 = "Name book?";
	private static final String WRITER_BOOK = "Writer book?";
	private static final String PRICE = "Price?";
	private static final String YEAR_YYYY = "Year? #yyyy#";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Logger log = Logger.getLogger(AddNewBookAction.class.getName());

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
		try {
			IOnlineBook onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			if (name != null && writer != null && price != null && quantity != null) {
				onlinebook.addNewBook(name, writer, price, quantity);
				print.printMessage(OPERATION_FINISH_SUCESS);
			} else {
				print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
			}
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
