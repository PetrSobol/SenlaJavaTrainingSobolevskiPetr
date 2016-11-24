package sort;
import java.util.Comparator;

import interfaces.IBook;

public class SortBookDate implements Comparator<IBook> {

	@Override
	public int compare(IBook o1, IBook o2) {
	    return o1.getQuantityPages().compareTo(o2.getQuantityPages());
	}

}
