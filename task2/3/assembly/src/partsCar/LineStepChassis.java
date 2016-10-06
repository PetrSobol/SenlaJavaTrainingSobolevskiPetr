package partsCar;

import IClassProduct.ILineStep;
import IClassProduct.IProductPart;

public class LineStepChassis implements ILineStep {

	public IProductPart buildProductPart() {
		System.out.println(".................");
		System.out.println("I spend construction Chassis ");
		return new Chassis();

	}

}
