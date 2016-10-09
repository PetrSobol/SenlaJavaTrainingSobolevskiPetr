package sortmass;

public class Runner {

	public static void main(String[] args) {
		String[] a = new String[] { "Petr", "Ania","Oksana","Aleksa","Dima","Eleanora" };
		SortMass sortmass=new SortMass();
        System.out.println("1: Unsorted array");
        sortmass.printArray(a);
        System.out.println("2: Sort an array");
        sortmass.printArray(sortmass.sortPrintMass(a));
        System.out.println("3: With a maximum length of element");
        System.out.println(sortmass.maxWordSize(a));
	}

}
