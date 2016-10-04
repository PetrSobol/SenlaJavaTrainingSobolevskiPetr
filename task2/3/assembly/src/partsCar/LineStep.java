package partsCar;

import IClassProduct.ILineStep;
import IClassProduct.IProductPart;

public class LineStep implements ILineStep {
	private IProductPart product;

	public LineStep(IProductPart productpart) {
		this.product = productpart;
	}

	public IProductPart buildProductPart() {
		System.out.println(".................");
		System.out.println("I spend construction  " + product.getName());
		return product;
	}
}
