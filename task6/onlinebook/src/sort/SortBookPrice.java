package sort;
import model.Book;
import java.util.Comparator;

public class SortBookPrice implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getPrice().compareTo(o2.getPrice());
	}

}
