package com.sobolevski.senla.onlinebook.operationmenu;

import java.util.List;

import com.sobolevski.senla.onlinebook.menu.IMenu;

public class PrintMenu {
	public void printMenu(List<IMenu> listmenu) {
		for (IMenu menu : listmenu) {
			System.out.println(menu.getId() + ": " + menu.getTitle());
		}

	}
}
