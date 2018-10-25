package Controlador;

import java.util.Vector;

import Negocio.*;

public class SARA {
private static SARA instancia=null;
private Vector<Empleado> empleados;
private Vector<Boleta> boletas;
private Vector<Cliente> clientes;
private Administrador administrador;

	private SARA(String us, String pass) {
		// TODO Auto-generated constructor stub
		empleados=	new Vector<Empleado>();
		boletas  =	new Vector<Boleta>();
		clientes =	new Vector<Cliente>();
		administrador= new Administrador(us,pass);
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
		if(instancia==null)
			instancia=new SARA(us,pass);
		return instancia;
	}
	
	public static SARA getInstancia(){
		return instancia;
	}

}
