package product;

public class Safe extends Product {
	private String name = "Safe";
	private Integer weight = 55;
	private String model;

	public Safe() {
		this.setName(name);
		this.setWeightProduct(weight);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
