package interfaces;

import java.text.ParseException;
import java.util.List;

import com.senla.sobol.model.IOrder;

public interface IOrderDao {
	public List<IOrder> getListOrder();

	public void deleteOrder(String name);

	public void addOrder(IOrder order);

	public IOrder searchOrderById(String number);

	public IOrder searchOrder(String name);

	public int searchOrderIndex(String name);

	public List<IOrder> listorderclock(String date1, String date2) throws ParseException;

	public void updateOrder(IOrder order, IOrder order2);

	public void setListorder(List<IOrder> listorder);
}
