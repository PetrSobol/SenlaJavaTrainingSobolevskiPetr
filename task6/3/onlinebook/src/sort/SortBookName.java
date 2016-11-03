package sort;

import java.util.Comparator;

import model.Book;

public class SortBookName implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
