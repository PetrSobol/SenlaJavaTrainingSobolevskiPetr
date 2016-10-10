package stock;

import product.Desk;
import product.Fridge;
import product.Safe;

public class Runner {

	public static void main(String[] args) {
		Desk desk = new Desk();
		Fridge fridge = new Fridge();
		Safe safe = new Safe();
		Stock stock = new Stock();
		stock.addProduct(safe);
		stock.addProduct(fridge);
		stock.addProduct(safe);
		stock.addProduct(desk);
		stock.addProduct(fridge);
		System.out.println("Goods stored in the warehouse:");
		System.out.println(stock);
		System.out.println("The total weight of goods stored in the warehouse (kg)");
		System.out.println(stock.getWeightProduct());

	}

}
