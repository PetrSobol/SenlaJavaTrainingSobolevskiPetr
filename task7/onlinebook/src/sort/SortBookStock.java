package sort;
import java.util.Comparator;

import interfaces.IBook;

public class SortBookStock implements Comparator<IBook> {
	
	@Override
	public int compare(IBook o2,IBook o1 ) {
		return o1.getStage().compareTo(o2.getStage());
	}
}
