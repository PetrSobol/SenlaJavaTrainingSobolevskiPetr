package controller;

import java.util.Collections;
import java.util.List;

import model.Book;
import service.BookService;
import sortings.SortingAlfovitu;
import sortings.SortingByPrice;

public class BookController {
	private BookService bookservice = new BookService();
	private StringBuilder stringbuilder;

	public void printListBookOll() {
		List<Book> listbook = bookservice.getListBook();
		for (Book books : listbook) {
			System.out.println(books.printInfoBook());

		}
	}

	public Boolean searchBook(Book book) {
		
		for (Book books : bookservice.getBooks()) {
			if (books.getName().equals(book.getName())) {
				return true;
			}

		}
		return false;
	}

	public void sortBookAlfovity() {
		Collections.sort(bookservice.getBooks(), new SortingAlfovitu());
		for (Book books : bookservice.getBooks()) {
			System.out.println(books.printInfoBook());
		}
	}

	public void sortBookByPrice() {
		Collections.sort(bookservice.getBooks(), new SortingByPrice());
		for (Book books : bookservice.getBooks()) {
			System.out.println(books.printInfoBook());
		}
	}

	public void writeNewBook(Book book) {
		if(!searchBook(book)){
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
			bookservice.writeBookCatalog(array);
		}else {
			System.out.println("This book use on stock!!");
		}
		

	}
}
