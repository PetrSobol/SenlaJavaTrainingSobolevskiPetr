package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;
import com.sobolevski.senla.onlinebook.operationmenu.ScannerBox;

public class CloneOrderAction implements IAction {
	private static final String NAMEMETOD = "cloneOrder";
	private static final String LASTNAME = "Lastname?";
	private ScannerBox scanerbox = new ScannerBox();
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	/**
	 * clone order
	 */
	@Override
	public void process(SupportClient supportaction) {
		print.printMessage(LASTNAME);
		String lastname = scanerbox.getWord();
		essence.setNameMetod(NAMEMETOD);
		Object[] array = { lastname };
		essence.setObjects(array);
		supportaction.getEssennce(essence);

	}

}
