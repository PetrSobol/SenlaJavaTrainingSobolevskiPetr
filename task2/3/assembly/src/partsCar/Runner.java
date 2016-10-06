package partsCar;

public class Runner {
	private LineStepBody linestepbody=new LineStepBody();
	private LineStepChassis linestepchassis=new LineStepChassis();
	private LineStepMotor linestepmotor=new LineStepMotor();
	private Car car=new Car();
	

	public static void main(String[] args) {
		System.out.println("Assembly conveyor to Car");
		Runner runner = new Runner();
		AssemblyLine assemblyLine=new AssemblyLine(runner.linestepbody, runner.linestepchassis,runner.linestepmotor);
        assemblyLine.assembleProduct(runner.car);
	}

}
