package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintOrderAnnotationAction implements IAction {
	private static final String ORDERANNOOTATIONDET = "orderannootationdet";
	private static final String ORDERANNOTATION = "orderannotation";
	private static final String DETAILED_INFORMATION = "Detailed information";
	private Print print = new Print();

	@Override
	public void process() {

		print.printMessage(Client.getInstance().getWordString(ORDERANNOTATION));
		print.printMessage(DETAILED_INFORMATION);
		print.printMessage(Client.getInstance().getWordString(ORDERANNOOTATIONDET));

	}

}
