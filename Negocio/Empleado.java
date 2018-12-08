package Negocio;

import Persistencia.AdmPersistenciaEmpleado;

public class Empleado extends Usuario {
	private int idEmpleado;
	private static int autonumerico;
	private String telefono, cuil;
	private boolean estado;

	public Empleado(String nombre, String apellido, String domicilio, 
			String dni, String localidad, String telefono, String cuil) {
		
		super(nombre, apellido, domicilio, dni, localidad);
		idEmpleado = getProxNumEmpleado();
		this.telefono = telefono;
		this.cuil = cuil;
		this.estado = true;
		AdmPersistenciaEmpleado.getInstancia().insert(this);
	}

	private int getProxNumEmpleado() {
		return ++autonumerico;
	}
	
	public static void iniciarAutoNumerico(int valorInicial){
		autonumerico=valorInicial;
	}
	public Empleado(){
		// TODO Auto-generated constructor stub
		super();
		idEmpleado=0;
		telefono="";
		cuil="";
	}
	
	
	public int getIdEmpleado() {
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
	public void delete() {
		// TODO Auto-generated method stub
		AdmPersistenciaEmpleado.getInstancia().delete(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		AdmPersistenciaEmpleado.getInstancia().update(this);
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		idEmpleado=id;
	}


	
	
	
}
