package action;

import java.text.ParseException;
import java.util.Scanner;

import operationmenu.SingleTonOnlineBook;

public class AddNewOrderAction implements IAction {
private Scanner scaner;
	@Override
	public void process() {
	scaner=new Scanner(System.in);
	System.out.println("Your lastname?");
	String lastname=scaner.nextLine();
	System.out.println("Your firstname?");
	String firstname=scaner.nextLine();
	System.out.println("Name book?");
	String namebook=scaner.nextLine();
	try {
		SingleTonOnlineBook.getInstance().getOnlineBook().addOrder(lastname, firstname, namebook);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	}

}
