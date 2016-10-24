package sort;

import java.util.Comparator;

import model.Order;

public class SortStageOrder implements Comparator<Order>{

	@Override
	public int compare(Order o1, Order o2) {
		return o1.getStage().compareTo(o2.getStage());
	}

}
