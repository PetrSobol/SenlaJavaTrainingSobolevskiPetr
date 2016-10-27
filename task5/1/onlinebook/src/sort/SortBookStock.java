package sort;
import model.Book;
import java.util.Comparator;

public class SortBookStock implements Comparator<Book> {
	
	@Override
	public int compare(Book o2,Book o1 ) {
		return o1.getStage().compareTo(o2.getStage());
	}
}
