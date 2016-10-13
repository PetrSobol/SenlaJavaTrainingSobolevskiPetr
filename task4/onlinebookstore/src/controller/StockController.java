package controller;

import java.util.List;

import model.Book;
import service.StockService;

public class StockController {
	private StringBuilder stringbuilder;
	private StockService stock = new StockService();

	public void printListBookOll() {
		List<Book> listbook = stock.getListBookStock();
		if (listbook != null) {
			for (Book books : listbook) {
				System.out.println(books.printInfoBook());
			}
		} else {
			System.out.println("empty warehouse!!!");
		}

	}

	public Boolean serachBookStock(Book book) {
		for (Book books : stock.getBooks()) {
			if (books.getName().equals(book.getName())) {
				return true;
			}
		}

		return false;

	}

	public Book searchBook(String namebook) {
		if (stock.getBooksCatalog() != null) {

			for (Book books : stock.getBooksCatalog()) {
				if (books.getName().equals(namebook)) {
					return books;
				}
			}

		}
		return null;
	}

	public void writeNewBook(String name) {

		Book book = searchBook(name);
		if (book != null) {
			if(!serachBookStock(book)){
				stringbuilder = new StringBuilder();
				stringbuilder.append(book.getName());
				stringbuilder.append(",");
				stringbuilder.append(book.getWriter());
				stringbuilder.append(",");
				stringbuilder.append(book.getPrice());
				stringbuilder.append(",");
				stringbuilder.append(book.getQuantityPages());
				String array[] = new String[1];
				array[0] = stringbuilder.toString();
				stock.writeBook(array);
				System.out.println("Книга успешно добавленна");
			} else {
				System.out.println("Такая книга уже есть на складе");
			}
			
		} else {
			System.out.println("Такой книги нет в каталоге ");
		}

	}
}
