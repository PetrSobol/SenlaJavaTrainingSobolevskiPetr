package com.sobolevski.senla.onlinebook.action;

import java.text.ParseException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class AddNewOrderAction implements IAction {
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private Logger log = Logger.getLogger(AddNewOrderAction.class.getName());
	private Scanner scaner;

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.addOrderLastname();
		String lastname = scanerbox.getWord(scaner);
		print.addOrderFirstName();
		String firstname = scanerbox.getWord(scaner);
		print.addbookName();
		String namebook = scanerbox.getWord(scaner);
		try {
			if (OnlineBook.getInstance().addOrder(lastname, firstname, namebook)) {
				print.printFinishOperation();
			} else {
				print.printNoFinishOperation();
			}
		} catch (ParseException e) {
			log.error(e);
		}
	}

}
