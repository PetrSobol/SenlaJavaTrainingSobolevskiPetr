package action;

import java.util.Scanner;

import operationmenu.SingleTonOnlineBook;

public class DeleteBookAction implements IAction {
	private Scanner scanner;

	@Override
	public void process() {
		scanner = new Scanner(System.in);
		System.out.println("Name book delete?");
		String name = scanner.nextLine();

		SingleTonOnlineBook.getInstance().getOnlineBook().deleteBook(name);

	}

}
