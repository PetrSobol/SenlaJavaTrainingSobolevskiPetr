package com.senla.sobol.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "writer")
public class Writer implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idWriter")
	private Integer idWriter;
	@Column(name = "lastnameWriter")
	private String lastname;
	@Column(name = "firstnameWriter")
	private String firstname;
	@Column(name = "yearOfBirthday")
	private String startYear;
	@Column(name = "diedYear")
	private String diedYear;
	@OneToMany(mappedBy="writer")
	private List<Book> listbook;


	public Writer() {
		super();
	}

	public Writer(String lastname, String firstname, String startYear) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.startYear = startYear;
	}

	public Writer(String lastname, String firstname, String startYear, String diedYear) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.startYear = startYear;
		this.diedYear = diedYear;
	}

	public Integer getIdWriter() {
		return idWriter;
	}

	public String getLastname() {
		return lastname;
	}

	public List<Book> getListbook() {
		return listbook;
	}

	public void setListbook(List<Book> listbook) {
		this.listbook = listbook;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getStartYear() {
		return startYear;
	}

	public String getDiedYear() {
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

	public void setStartYear(String startYear1) {
	
	
			this.startYear = startYear1;
	
	}

	public void setDiedYear(String diedYear1) {
	
			this.diedYear =diedYear1 ;
	
	}

}
