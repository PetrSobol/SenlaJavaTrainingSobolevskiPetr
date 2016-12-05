package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class QuantityFinishOrderAction implements IAction {
	private static final String NAMEMETOD = "printOrderFinish";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL = "Number of completed orders in the time interval   ";
	private static final String DATE_ONE_DD_MM_YYYY = "Date one? (dd.MM.yyyy)";
	private static final String DATE_TWO_DD_MM_YYYY = "Date two? (dd.MM.yyyy)";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * print quantity order in the range , FINISH_ORDER
	 */
	@Override
	public void process(SupportClient supportaction) {
		print.printMessage(DATE_ONE_DD_MM_YYYY);
		String date1 = scanerbox.dateFormat();
		print.printMessage(DATE_TWO_DD_MM_YYYY);
		String date2 = scanerbox.dateFormat();
		if (date1 != null && date2 != null) {
			essence.setNameMetod(NAMEMETOD);
			Object[] array = { date1, date2 };
			essence.setObjects(array);
			EssenceCommon essenceCommon = supportaction.getEssennce(essence);
			print.quantityOrder(
					NUMBER_OF_COMPLETED_ORDERS_IN_THE_TIME_INTERVAL + ":" + (Integer) essenceCommon.getCurront());
		} else {
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
		}

	}

}
