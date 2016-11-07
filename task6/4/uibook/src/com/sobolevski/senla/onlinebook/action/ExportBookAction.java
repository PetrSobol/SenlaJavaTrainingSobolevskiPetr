package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class ExportBookAction implements IAction{
	private static final String NAME_BOOK2 = "Name book?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private Scanner scaner;
	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.printMessage(NAME_BOOK2);
		String lastname = scanerbox.getWord(scaner);
		OnlineBook.getInstance().exportBookCSV(lastname);
	}

}
