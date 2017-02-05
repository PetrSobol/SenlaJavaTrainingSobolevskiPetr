package com.sobolevski.senla.onlinebook.operationmenu;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.senla.sobol.api.EssenceCommon;
import com.senla.sobol.api.SupportClient;
import com.sobolevski.senla.onlinebook.menu.BilderMenu;
import com.sobolevski.senla.onlinebook.menu.IMenu;

public class Navigator {
	private Print print = new Print();
	private BilderMenu bilder = new BilderMenu();
	private Logger loger = Logger.getLogger(Navigator.class.getName());
	private Scanner scanner;
	private SupportClient support;
	private EssenceCommon essenceexit;

	public Navigator(SupportClient supportClient) {
		this.support = supportClient;
		essenceexit = new EssenceCommon();
		essenceexit.setNameMetod("EXIT");

	}

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
										menus.getAction().process(support);
										print.printMenu(menu.getMenuList());
									}
								}
								if (numbers.equals(menu.getMenuList().size())) {
									print.printMenu(bilder.getListMenu());
									break;
								}
							}
						} else {
							menu.getAction().process(support);
						}
					}
				}
				if (number.equals(bilder.getListMenu().size())) {
					support.getEssennce(essenceexit);
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
