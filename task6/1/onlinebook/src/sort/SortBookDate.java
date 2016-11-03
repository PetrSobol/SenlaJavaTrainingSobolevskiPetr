package sort;
import model.Book;
import java.util.Comparator;

public class SortBookDate implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
	    return o1.getQuantityPages().compareTo(o2.getQuantityPages());
	}

}
