package Persistencia;

import java.util.Vector;

public abstract class AdministradorPersistencia {
	
	public abstract Object insert(Object o);
	
	public abstract void delete(Object o);
	
	public abstract void update(Object o);
	
	public abstract Vector<Object> select(Object o);
	
	
}
