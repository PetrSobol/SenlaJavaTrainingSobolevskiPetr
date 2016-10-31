package com.sobolevski.senla.onlinebook.action;

import java.text.ParseException;
import java.util.Scanner;

import loger.WriteLoger;
import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class QuantityFinishOrderAction implements IAction {
	private static final String QUANTITY_ORDER = "Number of completed orders in the time interval   ";
	private Scanner scaner;

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		System.out.println("Date one?(dd.MM.yyyy)");
		String date1 = scaner.nextLine();
		System.out.println("Date two?(dd.MM.yyyy)");
		String date2 = scaner.nextLine();
		try {
			System.out.println(
					QUANTITY_ORDER + SingleTonOnlineBook.getInstance().getOnlineBook().printOrderFinish(date1, date2));

		} catch (ParseException e) {
			WriteLoger.getLogger(QuantityFinishOrderAction.class.getName()).error(e);
		}

	}

}
