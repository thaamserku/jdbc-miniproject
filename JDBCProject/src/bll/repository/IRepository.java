package bll.repository;

import java.util.List;

public interface IRepository<T> {

	public abstract void addItem(T item);

	public abstract void deleteItem(int id);

	public abstract void updateItem(T item);

	public boolean getItemByID(int id);

	public abstract void getAllItem();

	// could not implement the following
	// need to loot at these later

	public abstract T findItem(T item);

//
	public abstract List<T> showAllItem();

}
