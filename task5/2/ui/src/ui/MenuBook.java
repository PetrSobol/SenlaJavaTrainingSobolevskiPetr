package ui;

import java.util.Scanner;

import controller.OnlineBook;

public class MenuBook implements IMenu {
	private static final String YEAR = "Year?";
	private static final String PRICE2 = "Price?";
	private static final String NAME_WRITER = "Name writer?";
	private static final String EXIT_DATABASE_BOOK = "Exit database book";
	private static final String PRINT_ALL_BOOK = "Print all book ";
	private static final String NAME_BOOK = "Name book";
	private static final String YOU_ADD_BOOK = "You add book";
	private OnlineBook onlinebook;
	private Scanner scanner;

	public MenuBook(OnlineBook onlinebook) {
		this.onlinebook = onlinebook;
		PrintInformation.printMenuBook();
		functionMenu();
	}

	public void functionMenu() {
		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			Integer i = scanner.nextInt();
			switch (i) {
			case 1:
				System.out.println(YOU_ADD_BOOK);
				System.out.println(NAME_BOOK);
				addNewBook();
				PrintInformation.printMenuBook();
				break;
			case 2:
				System.out.println(PRINT_ALL_BOOK);
				onlinebook.printBookAll();
				PrintInformation.printMenuBook();
				break;

			default:
				System.out.println(EXIT_DATABASE_BOOK);
				PrintInformation.printFirstMenu();
				break;
			}
			if (i == 3) {

				break;

			}
		}
	}

	private void addNewBook() {
		scanner = new Scanner(System.in);
		String name = null;
		String writer = null;
		Integer price = null;
		Integer quantity = null;
		while (scanner.hasNext()) {
			name = scanner.nextLine();
			System.out.println(NAME_WRITER);
			writer = scanner.nextLine();
			System.out.println(PRICE2);
			price = Integer.parseInt(scanner.nextLine());
			System.out.println(YEAR);
			quantity = Integer.parseInt(scanner.nextLine());
			break;
		}
		onlinebook.addNewBook(name, writer, price, quantity);
			}

}
