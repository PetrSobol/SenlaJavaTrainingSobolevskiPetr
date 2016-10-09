package library;

public class Library {
	private IBook books[];
	private IPerson person[];
	private StringBuilder stringbilder;

	public Library(Integer qualityBooks, Integer qualityPerson) {
		this.books = new Book[qualityBooks];
		this.person = new ReadPerson[qualityPerson];
	}

	public void printOll() {
		System.out.println("����� ����������: ");
		for (IBook books : this.books) {
			System.out.println(books.toString());
		}
		System.out.println("�������� ����������: ");
		for (IPerson persons : this.person) {
			System.out.println(persons.toString());
		}
	}

	public void addReadPersonLibrary(IPerson persons, Integer number) {
		this.person[number] = persons;

	}

	public void addBooksLibrary(IBook book, Integer number) {
		this.books[number] = book;

	}

	public void givesPersonBook(IPerson person, IBook book, Integer quantity) {
		person.addBookPerson(book, quantity);
		book.setLastNamePerson(person.getLastName());

	}

	public void printBookPerson(IPerson person) {
		person.printBookPerson();
	}

	public String whereBook(IBook book) {
		stringbilder = new StringBuilder();
		stringbilder.append("����� � ���������:");
		stringbilder.append(book.getName());
		stringbilder.append(" ��������� � �������� � �������� :");
		stringbilder.append(book.lastNamePerson());
		return stringbilder.toString();
	}

}
