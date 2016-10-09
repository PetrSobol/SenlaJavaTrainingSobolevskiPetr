package product;

public class Desk extends Product {
private Integer Lenght=10;
private String name="Desk";
private Integer weight=12;
public Desk(){
	this.setName(name);
	this.setWeightProduct(weight);
	}
public Integer getLenght() {
	return Lenght;
}
public void setLenght(Integer lenght) {
	Lenght = lenght;
}

}
