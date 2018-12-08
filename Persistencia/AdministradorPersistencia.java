package Persistencia;

import java.util.Vector;

/**
 * Interfaz que adopta una clase cualesquiera mediante el Simbolo generico
 * Todas clases que implementen esta interfaz podra hacer las operaciones 
 * de CRUDL
 * */
public interface AdministradorPersistencia <T>{
	
	/** 
	 * 
	 */
	public void insert(T o);
	
	 /** 
	  * 
	  */
	 public void delete(T o);
	 
	 /** 
	  * 
	  */
	 public void update(T o);
	 
	 /** 
	  * 
	  */	
	public T select(String id);
	 		 
	 /** 
	  * 
	  */
	public Vector<T> selectAll();
	
	int getIdMaximo();
}
