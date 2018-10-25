package Negocio;

import java.util.Vector;

public class Empleado extends Usuario {
	private String telefono, cuil;

	public Empleado(String nombre, String apellido, String domicilio, 
			String dni, String localidad, String telefono,String cuil) {
		
		super(nombre, apellido, domicilio, dni, localidad);
		
		this.telefono=telefono;
		this.cuil=cuil;
		
	}

	public Empleado(){
		// TODO Auto-generated constructor stub
		super();
		telefono="";
		cuil="";
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	@Override
	public Object insert(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
