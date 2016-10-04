package partsCar;

public class Runner {
	private Body body = new Body();
	private Chassis chassis = new Chassis();
	private Motor motor = new Motor();

	public static void main(String[] args) {
		System.out.println("Assembly conveyor to Car");
		Runner runner = new Runner();
		Car car = new Car();
		AssemblyLine assembly = new AssemblyLine();

		LineStep linestepbody = new LineStep(runner.body);
		linestepbody.buildProductPart();
		car.installFirstPart(runner.body);

		LineStep linestepchassis = new LineStep(runner.chassis);
		linestepchassis.buildProductPart();
		car.installSecondPart(runner.chassis);

		LineStep linestepmotor = new LineStep(runner.motor);
		linestepmotor.buildProductPart();
		car.installThirdPart(runner.motor);

		assembly.assembleProduct(car);

	}

}
