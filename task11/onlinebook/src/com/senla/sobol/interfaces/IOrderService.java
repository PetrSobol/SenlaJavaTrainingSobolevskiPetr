package com.senla.sobol.interfaces;

import java.util.Date;
import java.util.List;

import com.senla.sobol.model.IOrder;

public interface IOrderService {

	public IOrder getOrder(Integer idcustomer, Integer idbook, Date date);

	public Boolean searchIdBook(Integer idbook);

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String date);

	public void delete(IOrder t);

	public void update(IOrder t);

	public void add(IOrder t);

	public List<IOrder> getAll(String date);
}
