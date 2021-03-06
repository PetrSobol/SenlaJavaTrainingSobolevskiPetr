package sort;

import java.util.Comparator;

import model.Order;

public class SortPriceOrder implements Comparator<Order> {

	@Override
	public int compare(Order o1, Order o2) {
		return o1.getPrice().compareTo(o2.getPrice());
	}

}
