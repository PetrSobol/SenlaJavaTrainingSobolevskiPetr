package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class QuantityFinishOrderAction implements IAction {
	private static final String FINISHORDER = "finishorder";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL = "Number of completed orders in the time interval   ";
	private static final String DATE_ONE_DD_MM_YYYY = "Date one? (dd.MM.yyyy)";
	private static final String DATE_TWO_DD_MM_YYYY = "Date two? (dd.MM.yyyy)";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private StringBuilder string = new StringBuilder();

	/**
	 * print quantity order in the range , FINISH_ORDER
	 */
	@Override
	public void process() {
		print.printMessage(DATE_ONE_DD_MM_YYYY);
		String date1 = scanerbox.dateFormat();
		string.append(date1);
		string.append(",");
		print.printMessage(DATE_TWO_DD_MM_YYYY);
		String date2 = scanerbox.dateFormat();
		string.append(date2);
		if (date1 != null && date2 != null) {
			print.quantityOrder(NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL + ": "
					+ Client.getInstance().getDateServer(FINISHORDER, string.toString()));
		} else {
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
		}

	}

}
