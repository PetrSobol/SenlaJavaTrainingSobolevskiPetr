package controller;

import java.util.List;

import model.Book;
import service.StockService;

public class StockController {
	private StringBuilder stringbuilder;
	private StockService stock = new StockService();

	public void printListBookOll() {
		List<Book> listbook = stock.getListBookStock();
		if (listbook.size() != 0) {
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

	public void writeNewBook(Book book, BookController bookcontroller) {

		if (bookcontroller.searchBook(book)) {
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
				stock.writeBookStock(array);
			}else{
				System.out.println("This book use on stock");
			}
			} else {
			System.out.println("This book is not in the catalog!!!First add the book to the catalog");
		}
	}
}
