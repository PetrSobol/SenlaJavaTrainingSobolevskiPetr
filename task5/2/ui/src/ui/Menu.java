package ui;

import java.text.ParseException;
import java.util.Scanner;

import controller.OnlineBook;

public class Menu  {
	private FactoryMenu factoryMenu = new FactoryMenu();
	private Integer i;

	public Menu(OnlineBook onlineBook) throws ParseException {
		PrintInformation.printFirstMenu();
		creatMenu(onlineBook);
	}

	private void creatMenu(OnlineBook onlineBook) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			i = scanner.nextInt();
			if (factoryMenu.getMenu(i, onlineBook) == null) {
				onlineBook.saveToDataBases();
				break;
			}

		}

	}

}
