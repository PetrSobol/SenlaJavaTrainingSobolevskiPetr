package com.sobolevski.senla.onlinebook.action;

import com.sobolevski.senla.onlinebook.operationmenu.Print;

public class PrintBookAnnotationAction implements IAction {
	private static final String BOOKANNOTATIONDET = "bookannotationdet";
	private static final String BOOKANNOTATION = "bookannotation";
	private static final String DETAILED_INFORMATION = "Detailed information";
	private Print print = new Print();

	@Override
	public void process() {
		// give metod
		/*
		 * print.printMessage(Client.getInstance().getWordString(BOOKANNOTATION)
		 * ); print.printMessage(DETAILED_INFORMATION);
		 * print.printMessage(Client.getInstance().getWordString(
		 * BOOKANNOTATIONDET));
		 */

	}
}
