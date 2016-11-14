package interfaces;

import java.util.List;

public interface ISeriazeble {
	public void saveToDataBases();

	public List<IBook> getListBook();

	public List<IOrder> getListOrder();
}
