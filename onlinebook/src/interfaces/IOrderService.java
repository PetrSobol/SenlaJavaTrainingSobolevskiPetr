package interfaces;

import java.text.ParseException;
import java.util.List;

import com.senla.sobol.model.IOrder;
public interface IOrderService {
	public void closeOrder(String lastname, String firstname);

	public Boolean createNewOrder(String lastname, String firstname, String nameBook) throws ParseException;

	public void addCloneOrder(IOrder order);

	public List<IOrder> getListOrderClock(String date1, String date2) throws ParseException;

	public List<IOrder> getListOrder();

	public Boolean deleteOrder(String nameorder);

	public IOrder searchOrder(String name);

	public void updateOrder(IOrder order, IOrder order2);

	public IOrder searchOrderById(String number);

	public void setOrderdao(IOrderDao orderdao);

	public void setBookservice(IBookService bookservice);
}
