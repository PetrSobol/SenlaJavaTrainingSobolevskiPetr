package model;

import java.util.Calendar;
import java.util.List;

public class Order {
	private Integer id;
	private Order order;
	private Calendar calendar;
	private Integer price;

	public Order() {
		super();
	}

	public Order(Integer id, Order order, Calendar calendar, Integer price) {
		super();
		this.id = id;
		this.order = order;
		this.calendar = calendar;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
