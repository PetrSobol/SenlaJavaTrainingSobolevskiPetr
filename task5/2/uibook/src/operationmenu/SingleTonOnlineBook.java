package operationmenu;

import java.text.ParseException;

import controller.OnlineBook;

public class SingleTonOnlineBook {
	private OnlineBook onlinebook;
	private static SingleTonOnlineBook singleinstance;

	private SingleTonOnlineBook() throws ParseException {
		this.onlinebook = new OnlineBook();

	}

	public static SingleTonOnlineBook getInstance()  {
		if (singleinstance == null) {
			try {
				singleinstance = new SingleTonOnlineBook();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		return singleinstance;
	}

	public OnlineBook getOnlineBook() {
		return onlinebook;
	}

}
