package com.sobolevski.senla.onlinebook.action;
import org.apache.log4j.Logger;
import di.DI;
import interfaces.IOnlineBook;

public class ImportBookAction implements IAction {
	private Logger log = Logger.getLogger(ImportBookAction.class.getName());

	/**
	 * import list books in CSV
	 */
	@Override
	public void process() {
		IOnlineBook onlinebook;
		try {
			onlinebook = (IOnlineBook) DI.load(IOnlineBook.class);
			onlinebook.importBookCSV();
		} catch (InstantiationException e) {
			log.error(e);
		} catch (IllegalAccessException e) {
			log.error(e);
		} catch (ClassNotFoundException e) {
			log.error(e);
		}

	}

}
