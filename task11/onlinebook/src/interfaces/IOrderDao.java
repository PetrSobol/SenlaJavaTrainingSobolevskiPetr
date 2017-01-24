package interfaces;

import java.sql.Connection;
import java.util.List;

import com.senla.sobol.model.IOrder;

public interface IOrderDao extends ICommonDAO<IOrder> {
	public void setConnection(Connection connection);

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String dateOrder);
}
