package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class DeleteOrderAction implements IAction {
	private static final String DATE_ORDER_DD_MM_YYYY = "Date order?#dd.MM.yyyy#";
	private static final String ID_BOOK = "Id book?";
	private static final String ID_CUSTOMER = "Id customer?";
	private static final String DO_NOT_WRITE_DATE = "Do not write date!!!";
	private static final String NAMEMETOD = "deleteOrder";
	private Print print = new Print();
	private ScannerBox scanerbox = new ScannerBox();
	private EssenceCommon essence = new EssenceCommon();

	/**
	 * delete book
	 */
	@Override
	public void process(SupportClient supportaction) {
		print.printMessage(ID_CUSTOMER);
		Integer idcustomer = scanerbox.getNumber();
		print.printMessage(ID_BOOK);
		Integer idbook = scanerbox.getNumber();
		print.printMessage(DATE_ORDER_DD_MM_YYYY);
		String date = scanerbox.dateFormat();
		if (idbook != null && idcustomer != null && date != null) {
			essence.setNameMetod(NAMEMETOD);
			Object[] array = { idcustomer,idbook,date };
			essence.setObjects(array);
			supportaction.getEssennce(essence);

		}else{
			print.printMessage(DO_NOT_WRITE_DATE);
		}

	}
}
