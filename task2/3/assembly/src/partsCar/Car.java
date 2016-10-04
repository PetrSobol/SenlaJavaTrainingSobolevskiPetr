package partsCar;

import IClassProduct.IProduct;
import IClassProduct.IProductPart;

public class Car implements IProduct {

	@Override
	public void installFirstPart(IProductPart productpart) {
		System.out.println(".................");
		System.out.println("I spend installation first  " + productpart.getName());

	}

	@Override
	public void installSecondPart(IProductPart productpart) {
		System.out.println(".................");
		System.out.println("I spend installation second  " + productpart.getName());

	}

	@Override
	public void installThirdPart(IProductPart productpart) {
		System.out.println(".................");
		System.out.println("I spend installation third  " + productpart.getName());

	}

}
