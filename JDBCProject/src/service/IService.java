package service;

public interface IService<T> {

	public abstract void addItem(T item);

	public abstract void deleteItem(int id);

	public abstract void updateItem(T item);

	boolean getItemByID(int id);

	// public abstract T findItem(T item);

	// public abstract void displayFoundItem();

	// public abstract List<T> findItem();

	public abstract void getAllItem();

	public abstract void displayAllItem();

	public abstract void displayUpdatedItems();

}
