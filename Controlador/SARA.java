package Controlador;

import java.util.Vector;

import Negocio.*;

public class SARA {
private static SARA instancia=null;
private Vector<Empleado> empleados;
private Vector<Boleta> boletas;
private Vector<Cliente> clientes;
private Administrador administrador;

	private SARA() {
		// TODO Auto-generated constructor stub
		empleados=	new Vector<Empleado>();
		boletas  =	new Vector<Boleta>();
		clientes =	new Vector<Cliente>();
		administrador= new Administrador();
	}

	public Vector<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Vector<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Vector<Boleta> getBoletas() {
		return boletas;
	}

	public void setBoletas(Vector<Boleta> boletas) {
		this.boletas = boletas;
	}

	public Vector<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Vector<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public static SARA getInstancia(String us, String pass) {
		Administrador admin = new Administrador();
		if(admin.getNombreUsuario().equalsIgnoreCase(us) && admin.getContrasenia().equalsIgnoreCase(pass)){
			if(instancia == null)
				instancia=new SARA();
			return instancia;
		}
		else
			return null;
	}
	
	public static SARA getInstancia(){
		return instancia;
	}
	
}
