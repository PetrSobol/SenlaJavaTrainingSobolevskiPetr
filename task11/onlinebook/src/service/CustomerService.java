package service;

import java.util.List;

import com.senla.sobol.model.ICustomer;

import interfaces.ICustomerDao;
import interfaces.ICustomerService;

public class CustomerService implements ICustomerService {
	private ICustomerDao customerdao;

	public CustomerService() {
		super();
	}

	public CustomerService(ICustomerDao customerdao) {
		super();
		this.customerdao = customerdao;
	}

	@Override
	public void delete(ICustomer t) {
		customerdao.delete(t);

	}

	@Override
	public void update(ICustomer t) {
		customerdao.update(t);

	}

	@Override
	public void add(ICustomer t) {
		customerdao.addNew(t);

	}

	@Override
	public List<ICustomer> getAll() {
		List<ICustomer> listcustomer = customerdao.getReadAllTable();
		return listcustomer;
	}

	public ICustomer getCustomer(Integer idcustomer) {
		ICustomer customer = customerdao.getCustomer(idcustomer);
		return customer;
	}

	public void setCustomerdao(ICustomerDao customerdao) {
		this.customerdao = customerdao;
	}
	
}
