package com.sobolevski.senla.onlinebook.action;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

import di.DI;
import interfaces.IOnlineBook;

public class QuantityFinishOrderAction implements IAction {
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL = "Number of completed orders in the time interval   ";
	private static final String DATE_ONE_DD_MM_YYYY = "Date one? (dd.MM.yyyy)";
	private static final String DATE_TWO_DD_MM_YYYY = "Date two? (dd.MM.yyyy)";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private Logger log = Logger.getLogger(MuchOrderAction.class.getName());

	/**
	 * print quantity order in the range , FINISH_ORDER
	 */
	@Override
	public void process() {
		print.printMessage(DATE_ONE_DD_MM_YYYY);
		String date1 = scanerbox.dateFormat();
		print.printMessage(DATE_TWO_DD_MM_YYYY);
		String date2 = scanerbox.dateFormat();
		if (date1 != null && date2 != null) {
			try {
				IOnlineBook onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
				print.quantityOrder(NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL,
						onlinebook.printOrderFinish(date1, date2));
			} catch (ParseException e) {
				log.error(e);
			} catch (InstantiationException e) {
				log.error(e);
			} catch (IllegalAccessException e) {
				log.error(e);
			} catch (ClassNotFoundException e) {
				log.error(e);
			}
		} else {
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
		}

	}

}
