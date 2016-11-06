package com.sobolevski.senla.onlinebook.action;

import java.text.ParseException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class MuchOrderAction implements IAction {
	private Scanner scaner;
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Logger log = Logger.getLogger(MuchOrderAction.class.getName());

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.dateOne();
		String date1 = scanerbox.dateFormat(scaner);
		print.dateTwo();
		String date2 = scanerbox.dateFormat(scaner);
		if (date1 != null && date2 != null) {
			try {
				print.dateFinish(OnlineBook.getInstance().printOrderPriceToOrder(date1, date2));
			} catch (ParseException e) {
				log.error(e);
			}
		} else {
			print.printNoFinishOperation();
		}
	}

}
