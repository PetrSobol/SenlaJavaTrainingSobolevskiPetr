package sort;

import java.util.Comparator;

import com.senla.sobol.model.IWriter;

public class SortWriterName implements Comparator<IWriter> {

	@Override
	public int compare(IWriter o1, IWriter o2) {
		return o2.getLastname().compareTo(o1.getLastname());
	}

}
