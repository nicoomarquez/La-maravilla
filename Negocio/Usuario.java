package Negocio;

import Persistencia.AdministradorPersistencia;

public abstract class Usuario extends AdministradorPersistencia{
	protected String nombre, apellido, domicilio, dni, localidad;
	
	public Usuario(){
		nombre="";
		apellido="";
		domicilio="";		
		dni="";
		localidad="";
		
	}
	

	public Usuario(String nombre, String apellido, String domicilio, String dni, String localidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
		this.dni = dni;
		this.localidad = localidad;		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
}
