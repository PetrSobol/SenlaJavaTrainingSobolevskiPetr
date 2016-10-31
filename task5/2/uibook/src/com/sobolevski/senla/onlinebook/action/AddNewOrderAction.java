package com.sobolevski.senla.onlinebook.action;

import java.text.ParseException;
import java.util.Scanner;

import loger.WriteLoger;
import com.sobolevski.senla.onlinebook.operationmenu.SingleTonOnlineBook;

public class AddNewOrderAction implements IAction {
	private static final String THIS_BOOK_HAS_ALREADY_ORDERED_MORE_STOCK_NOT = "This book has already ordered more stock not";
	private static final String ORDER_SUCCES = "Order succes";
	private Scanner scaner;

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		System.out.println("Your lastname?");
		String lastname = scaner.nextLine();
		System.out.println("Your firstname?");
		String firstname = scaner.nextLine();
		System.out.println("Name book?");
		String namebook = scaner.nextLine();
		try {
			if (SingleTonOnlineBook.getInstance().getOnlineBook().addOrder(lastname, firstname, namebook)) {
				System.out.println(ORDER_SUCCES);
			} else {
				System.out.println(THIS_BOOK_HAS_ALREADY_ORDERED_MORE_STOCK_NOT);
			}

		} catch (ParseException e) {
			WriteLoger.getLogger(AddNewOrderAction.class.getName()).error(e);
		}

	}

}
