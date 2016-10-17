package sort;

import java.util.Comparator;

import model.Order;

public class SortDateOrder implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		return o1.dateFinishOrder().compareTo(o2.dateFinishOrder());
	}

}
