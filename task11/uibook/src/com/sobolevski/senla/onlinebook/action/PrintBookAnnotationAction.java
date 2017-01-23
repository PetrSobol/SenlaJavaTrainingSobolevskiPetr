package com.sobolevski.senla.onlinebook.action;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintBookAnnotationAction implements IAction {
	private static final String BOOKANNOTATIONDET = "getAnnotationBook";
	private static final String DETAILED_INFORMATION = "Detailed information";
	private Print print = new Print();
	private EssenceCommon essence = new EssenceCommon();
	private Boolean detaliedInf = true;
	private Boolean noDetaliedInformation = false;

	@Override
	public void process(SupportClient supportaction) {
		essence.setNameMetod(BOOKANNOTATIONDET);
		essence.setCurront(noDetaliedInformation);
		EssenceCommon essenceCommonNoDet = supportaction.getEssennce(essence);
		print.printMessage((String) essenceCommonNoDet.getCurront());
		print.printMessage(DETAILED_INFORMATION);
		essence.setNameMetod(BOOKANNOTATIONDET);
		essence.setCurront(detaliedInf);
		EssenceCommon essenceCommonDet = supportaction.getEssennce(essence);
		print.printMessage((String) essenceCommonDet.getCurront());

	}
}
