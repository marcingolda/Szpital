package pl.edu.pk.service;

import java.util.List;

public interface Crud<T> {
	public void save(T object);
	public T getById(int id);
	public List<T> getAll();
	public void delete(int id);
}
