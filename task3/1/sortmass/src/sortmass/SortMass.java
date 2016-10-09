package sortmass;

import java.util.Arrays;

public class SortMass {
	public String[] sortPrintMass(String[] mas) {
		Arrays.sort(mas);
		return mas;
	}

	public void printArray(String[] array) {
		for (String word : array) {
			System.out.println(word);
		}
	}

	public String maxWordSize(String array[]) {
		String maxWord = "";
		for (String a : array) {
			if (a.length() > maxWord.length()) {
				maxWord = a;
			}
		}
		return maxWord;
	}

}
