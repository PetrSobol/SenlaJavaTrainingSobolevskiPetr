package com.sobolevski.senla.onlinebook.operationmenu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.sobolevski.senla.onlinebook.client.Client;
import com.sobolevski.senla.onlinebook.menu.BilderMenu;
import com.sobolevski.senla.onlinebook.menu.IMenu;

public class Navigator {
	private Print print = new Print();
	private BilderMenu bilder = new BilderMenu();
	private Logger loger = Logger.getLogger(Navigator.class.getName());
	private Scanner scanner;

	public void startMenu() {
		print.printMenu(bilder.getListMenu());

		scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			try {

				Integer number = scanner.nextInt();

				for (IMenu menu : bilder.getListMenu()) {

					if (menu.getId().equals(number) && !menu.getId().equals(bilder.getListMenu().size())) {
						if (menu.getAction() == null) {
							print.printMenu(menu.getMenuList());

							scanner = new Scanner(System.in);
							while (scanner.hasNext()) {
								Integer numbers = scanner.nextInt();
								for (IMenu menus : menu.getMenuList()) {
									if (menus.getId().equals(numbers) && !numbers.equals(menu.getMenuList().size())
											&& menus.getAction() != null) {
										menus.getAction().process();
										print.printMenu(menu.getMenuList());
									}
								}
								if (numbers.equals(menu.getMenuList().size())) {
									print.printMenu(bilder.getListMenu());
									break;
								}
							}
						} else {
							menu.getAction().process();
						}
					}
				}
				if (number.equals(bilder.getListMenu().size())) {
					Client.getInstance().setWord("exit");
					Client.getInstance().close();
					break;
				}
			} catch (InputMismatchException e) {
				loger.error(e);
				startMenu();
				break;
			}
		}
	}

}
