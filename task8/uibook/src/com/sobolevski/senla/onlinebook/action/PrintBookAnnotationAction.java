package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintBookAnnotationAction implements IAction {
	private static final String BOOKANNOTATIONDET = "getAnnotationBook";
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();

	@Override
	public void process(SupportClient supportaction) {
		essence.setNameMetod(BOOKANNOTATIONDET);
		EssenceCommon essenceCommonNoDet = supportaction.getEssennce(essence);
		print.printMessage((String) essenceCommonNoDet.getCurront());

	}
}
