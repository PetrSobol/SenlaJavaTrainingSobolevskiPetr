package com.senla.sobol.model;


import java.util.Date;
import java.util.List;

public interface IWriter {
	public List<IBook> getListbook();

	public void setListbook(List<IBook> listbook);

	public Integer getIdWriter();

	public String getLastname();

	public String getFirstname();

	public Date getStartYear();

	public Date getDiedYear();

	public void setIdWriter(Integer idWriter);

	public void setLastname(String lastname);

	public void setFirstname(String firstname);

	public void setStartYear(Date startYear);

	public void setDiedYear(Date diedYear);
}
