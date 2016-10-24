package ui;

import controller.OnlineBook;

public class FactoryMenu {
	public IMenu getMenu(Integer i,OnlineBook book) {
		IMenu menu = null;
		if (i == 1) {
			menu = new MenuBook(book);
		} else if (i == 2) {
			menu = new MenuOrder(book);
		} else if (i == 3) {
			menu = null;
		}
		return menu;
	}
}
