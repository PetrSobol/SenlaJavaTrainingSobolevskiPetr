package sortings;

import java.util.Comparator;

import model.Book;

public class SortingByPrice implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		
		return o1.getPrice().compareTo(o2.getPrice());
	}

}
