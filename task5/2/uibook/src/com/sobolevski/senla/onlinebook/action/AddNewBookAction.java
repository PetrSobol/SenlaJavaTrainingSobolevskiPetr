package com.sobolevski.senla.onlinebook.action;

import java.util.Scanner;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class AddNewBookAction implements IAction {
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Scanner scaner;

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.addbookName();
		String name = scanerbox.getWord(scaner);
		print.addbookWriter();
		String writer = scanerbox.getWord(scaner);
		print.addbookPrice();
		Integer price = scanerbox.getNumber(scaner);
		print.addbookYear();
		Integer quantity = scanerbox.getNumber(scaner);
		if (name != null && writer!=  null && price != null && quantity != null) {
			OnlineBook.getInstance().addNewBook(name, writer, price, quantity);
			print.printFinishOperation();
		}else{
			print.printNoFinishOperation();
		}

	}

}
