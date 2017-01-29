package com.senla.sobol.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import com.senla.sobol.model.IBook;
import com.senla.sobol.model.IWriter;

public class Writer implements IWriter,Serializable {
	private Integer idWriter;
	private String lastname;
	private String firstname;
	private Date startYear;
	private Date diedYear;
	private List<IBook> listbook;

	public Writer() {
		super();
	}

	public Writer(String lastname, String firstname, Date startYear) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.startYear = startYear;
	}

	public Writer(String lastname, String firstname, Date startYear, Date diedYear) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.startYear = startYear;
		this.diedYear = diedYear;
	}

	public List<IBook> getListbook() {
		return listbook;
	}

	public void setListbook(List<IBook> listbook) {
		this.listbook = listbook;
	}

	public Integer getIdWriter() {
		return idWriter;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public Date getStartYear() {
		return startYear;
	}

	public Date getDiedYear() {
		return diedYear;
	}

	public void setIdWriter(Integer idWriter) {
		this.idWriter = idWriter;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setStartYear(Date startYear) {
		this.startYear = startYear;
	}

	public void setDiedYear(Date diedYear) {
		this.diedYear = diedYear;
	}

}
