package product;

import istock.IProduct;

public class Product implements IProduct {
	private String name;
	private Integer weighte;

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public Integer getWeightProduct() {

		return weighte;
	}

	@Override
	public void setWeightProduct(Integer weight) {
		this.weighte = weight;
	}

}
