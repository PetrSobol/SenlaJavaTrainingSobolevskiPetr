package partsCar;

import IClassProduct.IAssemblyLine;
import IClassProduct.IProduct;

public class AssemblyLine implements IAssemblyLine {
	private LineStepBody linestepbody;
	private LineStepChassis linestepchassis;
	private LineStepMotor linestepmotor;

	public AssemblyLine(LineStepBody linestepdody, LineStepChassis linestepchassis, LineStepMotor linestepmotor) {
		this.linestepbody = linestepdody;
		this.linestepchassis = linestepchassis;
		this.linestepmotor = linestepmotor;

	}

	@Override
	public IProduct assembleProduct(IProduct product) {
		product.installFirstPart(linestepbody.buildProductPart());
		product.installSecondPart(linestepmotor.buildProductPart());
		product.installThirdPart(linestepmotor.buildProductPart());
		System.out.println("The assembly car......");
		System.out.println(".....Mission Complete");
		return product;
	}

}
