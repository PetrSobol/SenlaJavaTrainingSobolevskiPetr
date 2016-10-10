package istock;

public interface IStock {
	public String getNameStock();

	public void setNameStock(String namestock);

	public void addProduct(IProduct product );

	public Integer getWeightProduct();
}
