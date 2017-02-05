package com.senla.sobol.interfaces;

import java.util.List;

import com.senla.sobol.model.Orders;

public interface IOrderService {

	public Orders getOrderId(Integer id);

	public List<Orders> getOrderByDateAndId(Integer idcustomer);

	public void delete(Orders t);

	public void update(Orders t);

	public void add(Orders t);

	public List<Orders> getAll(String date);
}
