package interfaces;

import com.senla.sobol.model.ICustomer;

public interface ICustomerService extends ICommonService<ICustomer> {
	public ICustomer getCustomer(Integer idcustomer);

	public void setCustomerdao(ICustomerDao customerdao);
}
