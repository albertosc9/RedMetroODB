package es.redmetro.asc.dao;

import java.util.List;

public interface IRedMetro<T>{
	
	public void crear(T entidad);
	public void borrar(T entidad);
	public T buscar(int codigo);
	public List<T> getLista();
}
