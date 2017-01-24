package interfaces;

import java.sql.Connection;

import com.senla.sobol.model.ICustomer;

public interface ICustomerDao extends ICommonDAO<ICustomer> {
	public ICustomer getCustomer(Integer idcustomer);

	public void setConnection(Connection connection);

}
