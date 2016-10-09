package sortmass;

public class Runner {

	public static void main(String[] args) {
		String[] a = new String[] { "Petr", "Ania","Oksana","Aleksa","Dima","Eleanora" };
		SortMass sortmass=new SortMass();
        System.out.println("Неотсортированный массив");
        sortmass.printArray(a);
        System.out.println("Отсортированный массив");
        sortmass.printArray(sortmass.sortPrintMass(a));
        System.out.println("Элемент с максимальной длиной");
        System.out.println(sortmass.maxWordSize(a));
	}

}
