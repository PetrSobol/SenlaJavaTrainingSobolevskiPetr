package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class DeleteBookAction implements IAction {
	private static final String NAME_BOOK2 = "Name book?";
	private Scanner scanner;
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();

	@Override
	public void process() {
		scanner = new Scanner(System.in);
		print.printMessage(NAME_BOOK2);
		String name = scanerbox.getWord(scanner);
		OnlineBook.getInstance().deleteBook(name);

	}

}
