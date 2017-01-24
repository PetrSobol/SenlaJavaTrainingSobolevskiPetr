package interfaces;

import java.util.List;

public interface ICommonDAO<T> {
	public  void addNew(T t);

	public List<T> getReadAllTable();

	public   void delete(T  t);

	public  void update(T t);

}
