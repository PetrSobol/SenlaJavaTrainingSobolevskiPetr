package model;

import java.text.SimpleDateFormat;

public class PrintInformationModel {
	private static final String STAGE2 = "  Stage: ";
	private static final String YEAR_OF_PUBLISHING = "  Year of publishing: ";
	private static final String PRICE_BOOK = "  Price book: ";
	private static final String WRITER2 = "  Writer: ";
	private static final String NAME_BOOK = " Name book: ";
	private static final String ORDER_STAGE = " Order stage: ";
	private static final String DATE_FINISH_ORDER = " Date finish order: ";
	private static final String DATE_ORDER = " Date order: ";
	private static final String PRICE2 = " Price: ";
	private static final String CUSTOMER_FIRSTNAME_ORDER = " Customer firstname order ";
	private static final String CUSTOMER_LASTNAME_ORDER = " Customer lastname order: ";
	private SimpleDateFormat simpledate=new SimpleDateFormat("dd.MM.yyyy");

	public String printInfoBook(Book book) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(book.getName());
		stringbuilder.append(WRITER2);
		stringbuilder.append(book.getWriter());
		stringbuilder.append(PRICE_BOOK);
		stringbuilder.append(book.getPrice());
		stringbuilder.append(YEAR_OF_PUBLISHING);
		stringbuilder.append(book.getQuantityPages());
		stringbuilder.append(STAGE2);
		stringbuilder.append(book.getStage());
		return stringbuilder.toString();
	}
	public String printInfoOrderOll(Order order) {
		StringBuilder stringbuilder = new StringBuilder();
		stringbuilder.append(CUSTOMER_LASTNAME_ORDER);
		stringbuilder.append(order.getLastname());
		stringbuilder.append(CUSTOMER_FIRSTNAME_ORDER);
		stringbuilder.append(order.getFirstname());
		stringbuilder.append(NAME_BOOK);
		stringbuilder.append(order.getBook().getName());
		stringbuilder.append(PRICE2);
		stringbuilder.append(order.getPrice());
		stringbuilder.append(DATE_ORDER);
		stringbuilder.append(simpledate.format(order.getDate()));
		stringbuilder.append(DATE_FINISH_ORDER);
		stringbuilder.append(simpledate.format(order.getDateFinishOrder()));
		stringbuilder.append(ORDER_STAGE);
		stringbuilder.append(order.getStage());
		return stringbuilder.toString();
	}


}
