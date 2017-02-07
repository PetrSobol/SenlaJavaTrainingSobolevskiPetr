package com.senla.sobol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.senla.sobol.intarfaces.AEntity;

@Entity
@Table(name = "customer")
public class Customer extends AEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCustomer")
	private Integer idCustomer;
	@Column(name = "lastnameCustomer")
	private String lastname;
	@Column(name = "firstnameCustomer")
	private String firstname;
	@Column(name = "phone")
	private Integer phone;
	@OneToMany(mappedBy = "customer",fetch=FetchType.LAZY)
	private List<Orders> listorder;

	public Customer() {
		super();
	}

	public Customer(String lastname, String firstname, Integer phone) {
		super();

		this.lastname = lastname;
		this.firstname = firstname;
		this.phone = phone;
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

	public List<Orders> getListorder() {
		return listorder;
	}

	public void setListorder(List<Orders> listorder) {
		this.listorder = listorder;
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
