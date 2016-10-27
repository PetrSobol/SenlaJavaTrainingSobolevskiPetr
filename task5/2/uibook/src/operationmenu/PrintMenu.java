package operationmenu;

import java.util.List;

import menu.IMenu;

public class PrintMenu {
	public void printMenu(List<IMenu> listmenu) {
		for (IMenu menu : listmenu) {
			System.out.println(menu.getId() +": "+ menu.getTitle());
		}

	}
}
