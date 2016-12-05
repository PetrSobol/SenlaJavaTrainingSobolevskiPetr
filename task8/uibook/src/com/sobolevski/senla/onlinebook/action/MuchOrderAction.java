package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class MuchOrderAction implements IAction {
	private static final String NAMEMETOD = "printOrderPriceToOrder";
	private static final String OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR = "Operation finish no sucess. Data entry error!! ";
	private static final String DATE_ONE_DD_MM_YYYY = "Date one? (dd.MM.yyyy)";
	private static final String DATE_TWO_DD_MM_YYYY = "Date two? (dd.MM.yyyy)";
	private static final String THE_COMPANY_EARNED_MONEY = "The company earned money -";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * where company gets money
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
		    print.quantityOrder(THE_COMPANY_EARNED_MONEY + ":" + (Integer) essenceCommon.getCurront());
		} else {
			print.printMessage(OPERATION_FINISH_NO_SUCESS_DATA_ENTRY_ERROR);
		}
	}

}
