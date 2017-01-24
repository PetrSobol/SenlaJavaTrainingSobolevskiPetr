package interfaces;

import java.util.List;

public interface ICommonService<T> {
	public void delete(T t);

	public void update(T t);

	public void add(T t);

	public List<T> getAll();

}
