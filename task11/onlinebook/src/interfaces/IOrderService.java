package interfaces;

import java.util.Date;
import java.util.List;

import com.senla.sobol.model.IOrder;

public interface IOrderService extends ICommonService<IOrder> {
	public void setOrderdao(IOrderDao orderdao);

	public IOrder getOrder(Integer idcustomer, Integer idbook, Date date);

	public Boolean searchIdBook(Integer idbook);

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String date);
}
