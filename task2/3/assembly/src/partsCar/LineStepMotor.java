package partsCar;

import IClassProduct.ILineStep;
import IClassProduct.IProductPart;

public class LineStepMotor implements ILineStep {

	@Override
	public IProductPart buildProductPart() {
		System.out.println(".................");
		System.out.println("I spend construction Motor " );
		return new Motor() ;
		
	}

}
