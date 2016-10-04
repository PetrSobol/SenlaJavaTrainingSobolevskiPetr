package partsCar;

import IClassProduct.IAssemblyLine;
import IClassProduct.IProduct;

public class AssemblyLine implements IAssemblyLine {

	@Override
	public IProduct assembleProduct(IProduct product) {
		System.out.println("The assembly car......");
		System.out.println(".....Mission Complete");
		return product;
	}

}
