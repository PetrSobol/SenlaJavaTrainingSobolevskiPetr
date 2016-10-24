package ui;

import controller.OnlineBook;

public class MenuOrder implements IMenu {
	private OnlineBook onlinebook;

	public MenuOrder(OnlineBook onlinebook) {
		this.onlinebook = onlinebook;
		PrintInformation.printMenuOrder();
	}

	@Override
	public  void functionMenu() {
		
		
	}
}
