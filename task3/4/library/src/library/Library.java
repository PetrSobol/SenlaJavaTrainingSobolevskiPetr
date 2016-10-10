package library;

public class Library {
	private IBook books[];
	private IPerson person[];
	private StringBuilder stringbilder;
	private Integer dimensionReadPerson=0;
	private Integer dimensionBooks=0;
	

	public Library(Integer qualityBooks, Integer qualityPerson) {
		this.books = new Book[qualityBooks];
		this.person = new ReadPerson[qualityPerson];
	}

	public void printOll() {
		System.out.println("Books library: ");
		for (IBook books : this.books) {
			System.out.println(books.toString());
		}
		System.out.println("ReadPerson library: ");
		for (IPerson persons : this.person) {
			System.out.println(persons.toString());
		}
	}

	public void addReadPersonLibrary(IPerson persons) {
		this.person[dimensionReadPerson] = persons;
		dimensionReadPerson++;

	}

	public void addBooksLibrary(IBook book) {
		this.books[dimensionBooks] = book;
		dimensionBooks++;

	}

	public void givesPersonBook(IPerson person, IBook book) {
		person.addBookPerson(book);
		book.setLastNamePerson(person.getLastName());

	}

	public void printBookPerson(IPerson person) {
		person.printBookPerson();
	}

	public String whereBook(IBook book) {
		stringbilder = new StringBuilder();
		stringbilder.append("Book with name:");
		stringbilder.append(book.getName());
		stringbilder.append(" It is the reader with the name :");
		stringbilder.append(book.lastNamePerson());
		return stringbilder.toString();
	}

}
