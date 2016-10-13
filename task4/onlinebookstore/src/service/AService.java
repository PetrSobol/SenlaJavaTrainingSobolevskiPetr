package service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public abstract class AService {
	private Integer getTranslateNumber(String numberstring) {
		String withoutProbellov = numberstring.replaceAll(" ", "");
		Integer numberInteger = Integer.parseInt(withoutProbellov);
		return numberInteger;
	}

	public <T> T[] anAssociation(T[] A, T[] B) {
		int a = A.length;
		int b = B.length;
		T[] C = (T[]) Array.newInstance(A.getClass().getComponentType(), a + b);
		System.arraycopy(A, 0, C, 0, a);
		System.arraycopy(B, 0, C, a, b);
		return C;
	}
	public List<Book> getListBook(List<Book> listbook,String[] array) {
		listbook = new ArrayList<Book>();
		String[] masBook = array;

		for (int i = 0; i < masBook.length; i++) {
			String[] wordString = masBook[i].split(",");
			Book book = new Book();
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
				/*
				 * switch (j) { case 0: book.setName(wordString[j]); case 1:
				 * book.setWriter(wordString[j]); case 2:
				 * System.out.println(wordString[j]);
				 * book.setPrice(getTranslateNumber(wordString[j])); case 3:
				 * System.out.println(wordString[j]);
				 * book.setQuantityPages(getTranslateNumber(wordString[j]));
				 * 
				 * }
				 */
			}
			listbook.add(book);
		}

		return listbook;
	}

	public abstract void writeBook(String word[]);
}
