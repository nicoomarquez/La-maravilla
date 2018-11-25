package Negocio;

import java.util.Vector;

import Persistencia.AdmPersistenciaCliente;

public class Cliente extends Usuario{
	private String codigoPostal, mail;
	private boolean estado;

	public Cliente(String nombre, String apellido, String dni, 
			String mail, String domicilio, String localidad, String codigoPostal) {
		super(nombre, apellido, domicilio, dni, localidad);
		
		this.codigoPostal = codigoPostal;
		this.mail = mail;
		this.estado = true; //cuando se da de alta un usuario siempre estara activo
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public void insertarCliente(Cliente c) {
		AdmPersistenciaCliente.getInstancia().insert(c);
	}

	@Override
	public void insert(Object o) {
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
