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
		stock.addProduct(safe, 0);
		stock.addProduct(fridge, 1);
		stock.addProduct(safe, 2);
		stock.addProduct(desk, 3);
		stock.addProduct(fridge, 4);
		System.out.println("Goods stored in the warehouse:");
		System.out.println(stock);
		System.out.println("The total weight of goods stored in the warehouse (kg)");
		System.out.println(stock.getWeightProduct());

	}

}
