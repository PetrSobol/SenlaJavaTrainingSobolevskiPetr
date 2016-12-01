package sort;

import java.util.Comparator;

import com.senla.sobol.model.IOrder;

public class SortPriceOrder implements Comparator<IOrder> {

	@Override
	public int compare(IOrder o1, IOrder o2) {
		return o1.getPrice().compareTo(o2.getPrice());
	}

}
