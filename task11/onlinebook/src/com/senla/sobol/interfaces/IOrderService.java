package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.IOrder;

public interface IOrderService {

	public IOrder getOrderId(Integer id);

	public List<IOrder> getOrderByDateAndId(Integer idcustomer, String date);

	public void delete(IOrder t);

	public void update(IOrder t);

	public void add(IOrder t);

	public List<IOrder> getAll(String date);
}
