package ui;

import java.text.ParseException;

import controller.OnlineBook;

public class Runner {

	public static void main(String[] args) {
		try {
			OnlineBook onlineBook=new OnlineBook();
			SingleTonMenu.getInstance( onlineBook).getMenu();
			
			
		} catch (ParseException e) {
				e.printStackTrace();
		}

	}

}
