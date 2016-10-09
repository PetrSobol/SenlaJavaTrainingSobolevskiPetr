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
		System.out.println("Товары которые хранятся на складе:");
		System.out.println(stock);
		System.out.println("Общий вес товаров, хранимый на складе (кг)");
		System.out.println(stock.getWeightProduct());

	}

}
