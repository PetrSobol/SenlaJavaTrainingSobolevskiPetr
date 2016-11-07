package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class AddNewBookAction implements IAction {
	private static final String OPERATION_FINISH_SUCESS = "Operation finish sucess";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String NAME_BOOK2 = "Name book?";
	private static final String WRITER_BOOK = "Writer book?";
	private static final String PRICE = "Price?";	
	private static final String YEAR_YYYY = "Year? #yyyy#";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Scanner scaner;

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.printMessage(NAME_BOOK2);
		String name = scanerbox.getWord(scaner);
		print.printMessage(WRITER_BOOK);
		String writer = scanerbox.getWord(scaner);
		print.printMessage(PRICE);
		Integer price = scanerbox.getNumber(scaner);
		print.printMessage(YEAR_YYYY);
		Integer quantity = scanerbox.getNumber(scaner);
		if (name != null && writer!=  null && price != null && quantity != null) {
			OnlineBook.getInstance().addNewBook(name, writer, price, quantity);
			print.printMessage(OPERATION_FINISH_SUCESS);
			}else{
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
		}

	}

}
