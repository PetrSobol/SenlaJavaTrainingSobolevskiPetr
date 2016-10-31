package com.sobolevski.senla.onlinebook.operationmenu;

import java.text.ParseException;

import controller.OnlineBook;
import loger.WriteLoger;

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
				WriteLoger.getLogger(SingleTonOnlineBook.class.getName()).error(e);
			}

		}
		return singleinstance;
	}

	public OnlineBook getOnlineBook() {
		return onlinebook;
	}

}
