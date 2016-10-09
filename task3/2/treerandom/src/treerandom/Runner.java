package treerandom;

import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		FunctionRandom function=new FunctionRandom();
		Integer[] mas = new Integer[3];
		System.out.println("Three randomly generated three-digit number");
		function.arrayRandom(mas);
		System.out.println("The amount of the first digits");
		function.aditionFirstNumber(mas);

		
	}

}
