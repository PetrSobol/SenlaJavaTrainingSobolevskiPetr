package library;

public class Book implements IBook {
	private String name;
	private String writer;
	private Integer memberOfPages;
	private StringBuilder stringbilder;
	private String lastNamePerson = " library ";

	public Book() {

	}

	public Book(String name, String writer, Integer memberOfPages) {
		this.name = name;
		this.writer = writer;
		this.memberOfPages = memberOfPages;
	}

	@Override
	public String getName() {

		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getWriter() {
		return writer;
	}

	@Override
	public void setWriter(String writer) {
		this.writer = writer;

	}

	@Override
	public Integer getMemberOfPages() {
		return memberOfPages;
	}

	@Override
	public void setMemberOfPages(Integer pages) {
		this.memberOfPages = pages;

	}

	@Override
	public String toString() {
		stringbilder = new StringBuilder();
		stringbilder.append(" Name:  ");
		stringbilder.append(getName());
		stringbilder.append(" ");
		stringbilder.append(" Writer: ");
		stringbilder.append(getWriter());
		stringbilder.append(" ");
		stringbilder.append("Quantity pages: ");
		stringbilder.append(getMemberOfPages());
		stringbilder.append("  Who is ");
		stringbilder.append(lastNamePerson);
		return stringbilder.toString();
	}

	@Override
	public String lastNamePerson() {

		return lastNamePerson;
	}

	@Override
	public void setLastNamePerson(String lastname) {
		this.lastNamePerson = lastname;

	}

}
