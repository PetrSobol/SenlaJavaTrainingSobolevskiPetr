package com.sobolevski.senla.onlinebook.action;

import java.text.ParseException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import controller.OnlineBook;

public class MuchOrderAction implements IAction {
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String DATE_ONE_DD_MM_YYYY = "Date one? (dd.MM.yyyy)";
	private static final String DATE_TWO_DD_MM_YYYY = "Date two? (dd.MM.yyyy)";
	private static final String THE_COMPANY_EARNED_MONEY = "The company earned money -";
	private Scanner scaner;
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Logger log = Logger.getLogger(MuchOrderAction.class.getName());

	@Override
	public void process() {
		scaner = new Scanner(System.in);
		print.printMessage(DATE_ONE_DD_MM_YYYY);
		String date1 = scanerbox.dateFormat(scaner);
		print.printMessage(DATE_TWO_DD_MM_YYYY);
		String date2 = scanerbox.dateFormat(scaner);
		if (date1 != null && date2 != null) {
			try {
				print.quantityOrder(THE_COMPANY_EARNED_MONEY,
						OnlineBook.getInstance().printOrderPriceToOrder(date1, date2));
			} catch (ParseException e) {
				log.error(e);
			}
		} else {
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
		}
	}

}
