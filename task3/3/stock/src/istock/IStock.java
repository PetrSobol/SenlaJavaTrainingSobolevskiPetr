package istock;

public interface IStock {
	public String getNameStock();

	public void setNameStock(String namestock);

	public void addProduct(IProduct product,Integer i );

	public Integer getWeightProduct();
}
