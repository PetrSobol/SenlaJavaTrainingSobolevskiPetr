package interfaces;

import java.util.Date;

import model.StageBook;
public interface IOrder {
	public Date getDate();

	public void setDate(Date date);

	public String getIdNumberOrder();

	public String getLastname();

	public String getFirstname();

	public void setIdNumberOrder(String idNumberOrder);

	public void setLastname(String lastname);

	public Integer getPrice();

	public void setPrice(Integer price);

	public void setFirstname(String firstname);

	public StageBook getStage();

	public Date getDateFinishOrder();

	public void setDateFinishOrder(Date date);

	public void setStage(StageBook stage);

	public Date dateFinishOrder();

	public IBook getBook();

	public void setBook(IBook book);

	public IOrder clone() throws CloneNotSupportedException;
}
