package action;

import java.text.ParseException;
import java.util.Scanner;

import operationmenu.SingleTonOnlineBook;

public class MuchOrderAction implements IAction {
private Scanner scaner;
	@Override
	public void process() {
		scaner=new Scanner(System.in);
		System.out.println("Date one? (dd.MM.yyyy)");
		String date1=scaner.nextLine();
		System.out.println("Date two? (dd.MM.yyyy)");
		String date2=scaner.nextLine();
		try {
			SingleTonOnlineBook.getInstance().getOnlineBook().sortOrderDateToPrice(date1, date2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
