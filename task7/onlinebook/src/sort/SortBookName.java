package sort;

import java.util.Comparator;

import interfaces.IBook;

public class SortBookName implements Comparator<IBook> {

	@Override
	public int compare(IBook o1, IBook o2) {
		
		return o1.getName().compareTo(o2.getName());
	}

}
