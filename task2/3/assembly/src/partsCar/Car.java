package partsCar;

import IClassProduct.IProduct;
import IClassProduct.IProductPart;

public class Car implements IProduct {
	private Body body;
	private Chassis chassis;
	private Motor motor;

	@Override
	public void installFirstPart(IProductPart productpart) {
		this.body = (Body) productpart;

		System.out.println(".................");
		System.out.println("I spend installation first  " + body.getName());

	}

	@Override
	public void installSecondPart(IProductPart productpart) {
		this.chassis = (Chassis) productpart;
		System.out.println(".................");
		System.out.println("I spend installation second  " + chassis.getName());

	}

	@Override
	public void installThirdPart(IProductPart productpart) {
		this.motor = (Motor) productpart;
		System.out.println(".................");
		System.out.println("I spend installation third  " + motor.getName());

	}

}
