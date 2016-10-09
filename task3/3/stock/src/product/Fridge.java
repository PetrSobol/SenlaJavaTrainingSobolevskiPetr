package product;

public class Fridge extends Product {
	private String name = "Fridge";
	private String color;
	private Integer weight = 24;

	public Fridge() {
		this.setName(name);
		this.setWeightProduct(weight);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
