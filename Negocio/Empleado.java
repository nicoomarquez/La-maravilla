package Negocio;

import java.util.Vector;

public class Empleado extends Usuario {
	private static int idEmpleado;
	private String telefono, cuil;
	private boolean estado;

	public Empleado(String nombre, String apellido, String domicilio, 
			String dni, String localidad, String telefono, String cuil) {
		
		super(nombre, apellido, domicilio, dni, localidad);
		idEmpleado = getProxNumEmpleado();
		this.telefono=telefono;
		this.cuil=cuil;
		this.estado=true;
	}

	private int getProxNumEmpleado() {
		return ++idEmpleado;
	}

	public Empleado(){
		// TODO Auto-generated constructor stub
		super();
		idEmpleado=0;
		telefono="";
		cuil="";
	}
	
	
	public static int getIdEmpleado() {
		return idEmpleado;
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
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
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
