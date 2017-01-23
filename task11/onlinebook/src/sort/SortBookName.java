package sort;

import java.util.Comparator;

import com.senla.sobol.model.IBook;
public class SortBookName implements Comparator<IBook> {

	@Override
	public int compare(IBook o1, IBook o2) {
		
		return o1.getNameBook().compareTo(o2.getNameBook());
	}

}
