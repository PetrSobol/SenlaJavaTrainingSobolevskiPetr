package model;

import java.io.Serializable;
import java.util.List;

import com.senla.sobol.model.ICustomer;
import com.senla.sobol.model.IOrder;

public class Customer implements ICustomer,Serializable {
	private Integer idCustomer;
	private String lastname;
	private String firstname;
	private Integer phone;
	private List<IOrder> listorder;

	public Customer() {
		super();
	}

	public Customer(String lastname, String firstname, Integer phone) {
		super();

		this.lastname = lastname;
		this.firstname = firstname;
		this.phone = phone;
	}

	public List<IOrder> getListorder() {
		return listorder;
	}

	public void setListorder(List<IOrder> listorder) {
		this.listorder = listorder;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

}
