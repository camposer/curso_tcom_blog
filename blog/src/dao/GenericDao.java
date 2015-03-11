package dao;

import java.util.List;

public interface GenericDao<T, K> {
	public void agregar(T obj);
	public void modificar(T obj);
	public void eliminar(K id);
	public T obtener(K id);
	public List<T> obtenerTodos();
}
