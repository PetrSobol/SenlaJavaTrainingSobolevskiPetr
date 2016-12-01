package interfaces;

import java.util.List;

import com.senla.sobol.model.IBook;
import com.senla.sobol.model.IOrder;

public interface ISeriazeble {
	public void saveToDataBases();

	public List<IBook> getListBook();

	public List<IOrder> getListOrder();
}
