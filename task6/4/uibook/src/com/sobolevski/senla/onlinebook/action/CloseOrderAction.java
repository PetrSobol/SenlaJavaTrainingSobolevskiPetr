package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;


public class CloseOrderAction implements IAction {
	private static final String YOUR_LASTNAME = "Your lastname?";
	private static final String YOUR_FIRSTNAME = "Your firstname?";
	private Scanner scaner;
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.printMessage(YOUR_LASTNAME);
		String lastname = scanerbox.getWord(scaner);
		print.printMessage(YOUR_FIRSTNAME);	
		String firstname = scanerbox.getWord(scaner);
		OnlineBook.getInstance().closeOrder(lastname, firstname);
	}

}
