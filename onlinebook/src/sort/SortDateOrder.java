package sort;

import java.util.Comparator;

import interfaces.IOrder;

public class SortDateOrder implements Comparator<IOrder>{

	@Override
	public int compare(IOrder o1, IOrder o2) {
		return o1.dateFinishOrder().compareTo(o2.dateFinishOrder());
	}

}
