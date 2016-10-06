package partsCar;

import IClassProduct.ILineStep;
import IClassProduct.IProductPart;

public class LineStepBody implements ILineStep {
	   
	public IProductPart buildProductPart() {
		System.out.println(".................");
		System.out.println("I spend construction Body " );
		return new Body() ;
	}
}
