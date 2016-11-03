package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class DeleteBookAction implements IAction {
	private Scanner scanner;
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();

	@Override
	public void process() {
		scanner = new Scanner(System.in);
		print.addbookName();
		String name = scanerbox.getWord(scanner);
		OnlineBook.getInstance().deleteBook(name);

	}

}
