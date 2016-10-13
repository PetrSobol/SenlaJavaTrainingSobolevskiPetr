package service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import database.DataBase;
import model.Book;

public class StockService {
	private DataBase database = new DataBase();
	private List<Book> listbook;
	private Book book;
	private String masBook[];
	private String wordString[];

	private Integer getTranslateNumber(String numberstring) {
		String withoutProbellov = numberstring.replaceAll(" ", "");
		Integer numberInteger = Integer.parseInt(withoutProbellov);
		return numberInteger;
	}

	private <T> T[] anAssociation(T[] A, T[] B) {
		int a = A.length;
		int b = B.length;
		T[] C = (T[]) Array.newInstance(A.getClass().getComponentType(), a + b);
		System.arraycopy(A, 0, C, 0, a);
		System.arraycopy(B, 0, C, a, b);
		return C;
	}

	public List<Book> getBooks() {
		return this.listbook;
	}

	public List<Book> getListBookStock() {
		listbook = new ArrayList<Book>();
		masBook = database.getBookStock();

		for (int i = 0; i < masBook.length; i++) {
			wordString = masBook[i].split(",");
			book = new Book();
			for (int j = 0; j < wordString.length; j++) {
				if (j == 0) {
					book.setName(wordString[j]);
				} else if (j == 1) {
					book.setWriter(wordString[j]);
				} else if (j == 2) {
					book.setPrice(getTranslateNumber(wordString[j]));
				} else {
					book.setQuantityPages(getTranslateNumber(wordString[j]));
				}
			
			}
			listbook.add(book);
		}

		return listbook;
	}

	public void writeBookStock(String word[]) {
		String[] books = database.getBookStock();
		database.addBookStock(anAssociation(books, word));
	}
}
