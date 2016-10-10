package stock;

import istock.IProduct;
import istock.IStock;
import product.Product;

public class Stock implements IStock {
	private String name;
	private Integer weight = 0;
	private IProduct product[] = new Product[5];
	private StringBuilder builder;
	private Integer quantity=1;
	private Integer dimension=0;

	@Override
	public String getNameStock() {

		return name;
	}

	@Override
	public void setNameStock(String namestock) {
		this.name = namestock;
	}

	@Override
	public void addProduct(IProduct product) {
		this.product[dimension] = product;
		this.weight += product.getWeightProduct();
		dimension++;
	}

	@Override
	public Integer getWeightProduct() {

		return weight;
	}

	private String printProductArray() {
		builder = new StringBuilder();
		for (IProduct products : product) {
			builder.append(quantity);
			builder.append(": ");
			builder.append(products.getName());
			builder.append(" ");
			quantity++;
		}

		return builder.toString();
	}

	@Override
	public String toString() {
		return printProductArray();
	}

}
