package Negocio;

import java.util.Vector;

public class Cliente extends Usuario{
	private String codigoPostal, mail;
	private boolean estado;

	public Cliente(String nombre, String apellido, String domicilio, 
			String dni, String localidad,String codigoPostal, String mail) {
		super(nombre, apellido, domicilio, dni, localidad);
		// TODO Auto-generated constructor stub
		this.codigoPostal=codigoPostal;
		this.mail=mail;
		this.estado=true; //cuando se da de alta un usuario siempre estara activo
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
