package Negocio;

import Persistencia.AdmPersistenciaCliente;

public class Cliente extends Usuario{
	private String codigoPostal, mail;
	private boolean estado;
	private int idCliente;
	private static int autonumerico;
	
	public Cliente(String nombre, String apellido, String dni, 
			String mail, String domicilio, String localidad, String codigoPostal) {
		super(nombre, apellido, domicilio, dni, localidad);
		idCliente=getSiguiente();
		this.codigoPostal = codigoPostal;
		this.mail = mail;
		this.estado = true;
		AdmPersistenciaCliente.getInstancia().insert(this);
	}

	private static int getSiguiente() {
		// TODO Auto-generated method stub
		return ++autonumerico;
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

	public int getId(){
		return idCliente;
	}
	
	public void setId(int id) {
		// TODO Auto-generated method stub
		idCliente=id;
	}
	
	public void setEstado(boolean estado){
		this.estado=estado;
	}
	
	public boolean getEstado(){
		return estado;
	}
	
	public static void iniciarAutoNumerico(int valorInicial){
		autonumerico=valorInicial;
	}
	
	public boolean sosElCliente(String dni){
		return this.dni.equals(dni);
	}
	
	@Override
	public void delete() {
		AdmPersistenciaCliente.getInstancia().delete(this);
	
	}

	@Override
	public void update() {
		AdmPersistenciaCliente.getInstancia().update(this);
	}

	
	
}
