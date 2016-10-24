package ui;

import java.text.ParseException;

import controller.OnlineBook;

public class SingleTonMenu {
	private static SingleTonMenu singleinstance;
	private Menu menu;

	private SingleTonMenu(OnlineBook onlinebook) throws ParseException {
		menu = new Menu(onlinebook);
		
	}

	public static SingleTonMenu getInstance(OnlineBook onlinebook) throws ParseException {
		if (singleinstance == null) {
			singleinstance = new SingleTonMenu(onlinebook);
			
		}
		return singleinstance;
	}
	
	public Menu getMenu() {
		return menu;
	}

}
