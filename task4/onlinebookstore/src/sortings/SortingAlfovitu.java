package sortings;

import java.util.Comparator;

import model.Book;

public class SortingAlfovitu implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
