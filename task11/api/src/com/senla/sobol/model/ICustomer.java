package com.senla.sobol.model;

import java.util.List;

public interface ICustomer {
	public List<IOrder> getListorder();

	public void setListorder(List<IOrder> listorder);

	public Integer getIdCustomer();

	public String getLastname();

	public String getFirstname();

	public Integer getPhone();

	public void setIdCustomer(Integer idCustomer);

	public void setLastname(String lastname);

	public void setFirstname(String firstname);

	public void setPhone(Integer phone);
}
