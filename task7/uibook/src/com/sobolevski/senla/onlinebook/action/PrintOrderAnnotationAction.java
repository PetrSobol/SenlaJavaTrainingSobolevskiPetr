package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobol.senla.anotation.PrintableTracker;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

import model.Order;

public class PrintOrderAnnotationAction implements IAction {
	private static final String DETAILED_INFORMATION = "Detailed information";
	private Logger log = Logger.getLogger(PrintOrderAnnotationAction.class.getName());
	private Print print = new Print();

	@Override
	public void process() {
		try {
			print.printMessage(PrintableTracker.getInstance().prinInformation(Order.class, false));
			print.printMessage(DETAILED_INFORMATION);
			print.printMessage(PrintableTracker.getInstance().prinInformation(Order.class, true));
			
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
