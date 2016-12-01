package com.senla.sobol.model;

public interface IBook {
	public String getName();

	public void setName(String name);

	public String getWriter();

	public void setWriter(String writer);

	public Integer getPrice();

	public IOrder getOrder();

	public void setOrder(IOrder order);

	public void setPrice(Integer price);

	public Integer getQuantityPages();

	public void setQuantityPages(Integer quantityPages);

	public StageBook getStage();

	public String getId();

	public void setId(String id);

	public void setStage(StageBook stage);
}
