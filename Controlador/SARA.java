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
		empleados =	new Vector<Empleado>();
		boletas  =	new Vector<Boleta>();
		clientes =	new Vector<Cliente>();
		administrador = new Administrador();
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
		if (instancia == null)
			instancia = new SARA();
		return instancia;
	}

	public boolean dniRepetido(String dniIngresado) {
		for(int i = 0;  i < clientes.size(); i++) {
			if(clientes.elementAt(i).getDni().equals(dniIngresado))
				return true;
		}
		return false;
	}

	public boolean mailRepetido(String mailIngresado) {
		for(int i = 0;  i < clientes.size(); i++) {
			if(clientes.elementAt(i).getMail().equals(mailIngresado))
				return true;
		}
		return false;
	}

	public void crearCliente(String nombre, String apellido, String dni, String mail, String domicilio, String localidad,
			String codigoPostal) {
		// Las verificaciones de que el cliente ya existe se hacen en la pantala CrearCliente
		// cuando se verifica que el dni y mail ingresado no sean repetidos
		Cliente clienteNuevo = new Cliente(nombre, apellido, dni, mail, domicilio, localidad, codigoPostal);
		clientes.add(clienteNuevo);
	}

	public Cliente buscarCliente(String dniIngresado) {
		//primero pregunto si el dni es repetido
		//si no es repetido, busco en el vector de clientes y devuelvo aquel que tenga el mismo dni ingresado
		if(dniRepetido(dniIngresado)) {
			for(int i = 0; i < clientes.size(); i++) {
				if(clientes.elementAt(i).getDni().equals(dniIngresado))
					return clientes.elementAt(i);
			}
		}
		return null;
	}	
	
	public Vector <Boleta> getBoletasCliente(String dni){
		Vector<Boleta> b = new Vector<Boleta>();
		for(int i=0; i<boletas.size(); i++){
			if(boletas.elementAt(i).getCliente().getDni().equalsIgnoreCase(dni) && boletas.elementAt(i).getEstado() == 'P')
				b.add(boletas.elementAt(i));
		}
		return b;
	}
	
}
