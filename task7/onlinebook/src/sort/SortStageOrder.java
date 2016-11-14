package sort;

import java.util.Comparator;

import interfaces.IOrder;

public class SortStageOrder implements Comparator<IOrder>{

	@Override
	public int compare(IOrder o1, IOrder o2) {
		return o1.getStage().compareTo(o2.getStage());
	}

}
