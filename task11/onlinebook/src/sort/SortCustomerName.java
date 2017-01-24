package sort;

import java.util.Comparator;

import com.senla.sobol.model.ICustomer;

public class SortCustomerName implements Comparator<ICustomer> {

	@Override
	public int compare(ICustomer o1, ICustomer o2) {
		return o1.getLastname().compareTo(o2.getLastname());
	}

}
