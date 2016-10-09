package treerandom;

import java.util.Random;

public class FunctionRandom {
	public Integer[] arrayRandom(Integer mas[]) {

		for (int i = 0; i < mas.length; i++) {
			mas[i] = new Random().nextInt(999 - 100) + 100;
			System.out.println(mas[i]);

		}
		return mas;
	}

	public void aditionFirstNumber(Integer mas[]) {
		Integer a = 0;

		for (int i = 0; i < mas.length; i++) {
			a += mas[i] / 100;

		}
		System.out.println(a);
	}

}
