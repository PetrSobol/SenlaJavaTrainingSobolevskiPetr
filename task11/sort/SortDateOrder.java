package sort;

import java.util.Comparator;

import com.senla.sobol.model.IOrder;


public class SortDateOrder implements Comparator<IOrder>{

	@Override
	public int compare(IOrder o1, IOrder o2) {
		return o1.getDateOrder().compareTo(o2.getDateOrder());
	}

}
