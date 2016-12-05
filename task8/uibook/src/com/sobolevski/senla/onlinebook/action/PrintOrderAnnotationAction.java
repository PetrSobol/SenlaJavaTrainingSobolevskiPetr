package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintOrderAnnotationAction implements IAction {
	private static final String ORDERANNOOTATIONDET = "getAnnotationOrder";
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	@Override
	public void process(SupportClient supportaction) {

		essence.setNameMetod(ORDERANNOOTATIONDET);
		EssenceCommon essenceCommonNoDet = supportaction.getEssennce(essence);
		print.printMessage((String) essenceCommonNoDet.getCurront());
		
	}

}
