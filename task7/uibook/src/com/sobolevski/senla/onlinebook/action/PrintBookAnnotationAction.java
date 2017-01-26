package com.sobolevski.senla.onlinebook.action;

import org.apache.log4j.Logger;

import com.sobol.senla.anotation.PrintableTracker;
import com.sobolevski.senla.onlinebook.operationmenu.Print;

import model.Book;

public class PrintBookAnnotationAction implements IAction {
	private static final String DETAILED_INFORMATION = "Detailed information";
	private Logger log = Logger.getLogger(PrintOrderAnnotationAction.class.getName());
	private Print print = new Print();

	@Override
	public void process() {
		try {
			print.printMessage(PrintableTracker.getInstance().prinInformation(Book.class, false));
			print.printMessage(DETAILED_INFORMATION);
			print.printMessage(PrintableTracker.getInstance().prinInformation(Book.class, true));
			
		} catch (ClassNotFoundException e) {
			log.error(e);
		}
	}
}
