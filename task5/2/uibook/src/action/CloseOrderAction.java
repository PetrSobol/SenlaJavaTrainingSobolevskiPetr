package action;

import java.util.Scanner;

import operationmenu.SingleTonOnlineBook;

public class CloseOrderAction implements IAction {
	private Scanner scaner;

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		System.out.println("Your lastname?");
		String lastname = scaner.nextLine();
		System.out.println("Your firstname?");
		String firstname = scaner.nextLine();
		SingleTonOnlineBook.getInstance().getOnlineBook().closeOrder(lastname, firstname);

	}

}
