package Controlador;

import java.util.Vector;

import Negocio.*;
import Persistencia.AdmPersistenciaArreglo;
import Persistencia.AdmPersistenciaBoleta;
import Persistencia.AdmPersistenciaCliente;
import Persistencia.AdmPersistenciaEmpleado;

public class SARA {
private static SARA instancia=null;
private Vector<Empleado> empleados;
private Vector<Boleta> boletas;
private Vector<Cliente> clientes;
private Vector<Arreglo> arreglos;
private Administrador administrador;
private static int codigoCalzado;

	private SARA() {
		// TODO Auto-generated constructor stub
		iniciarTodosLosAutoNumericos();
		empleados =	(Vector<Empleado>) AdmPersistenciaEmpleado.getInstancia().selectAll();
		boletas  =	new Vector<Boleta>();
		clientes =	new Vector<Cliente>();
		arreglos = (Vector<Arreglo>) AdmPersistenciaArreglo.getInstancia().selectAll();
		/*Arreglo a = new Arreglo("Suela rota", "Reparacion de suelas de zapatos para hombre", 90);
		Arreglo b = new Arreglo("Suela limpia", "Reparacion de suelas de zapatos para mujer", 50);
		arreglos.add(a);
		arreglos.add(b);
		Empleado e = new Empleado("Luis", "Martinez", "San Juan 154", "20145785", "CABA", "11111111", "2-4548412-5");
		empleados.add(e);
		Empleado e1 = new Empleado("Jose", "Gomez", "San Juan 154", "20145785", "CABA", "11111111", "2-4548412-5");
		empleados.add(e1);*/
		administrador = new Administrador();
	}

	private void iniciarTodosLosAutoNumericos() {
		// TODO Auto-generated method stub
		int boletaMax=AdmPersistenciaBoleta.getInstancia().getIdMaximo();
		int clienteMax=AdmPersistenciaCliente.getInstancia().getIdMaximo();
		int empleadoMax=AdmPersistenciaEmpleado.getInstancia().getIdMaximo();
		int arregloMax=AdmPersistenciaArreglo.getInstancia().getIdMaximo();
		
		Boleta.iniciarAutoNumerico(boletaMax);
		Cliente.iniciarAutoNumerico(clienteMax);
		Empleado.iniciarAutoNumerico(empleadoMax);
		Arreglo.iniciarAutoNumerico(arregloMax);
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

	public void setArreglos(Vector<Arreglo> arreglos) {
		this.arreglos = arreglos;
	}
	
	public Vector<Arreglo> getArreglos()
	{
		return arreglos;
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
		//Busco en la base de datos
		return AdmPersistenciaCliente.getInstancia().dniRepetido(dniIngresado);	
	}

	public boolean mailRepetido(String mailIngresado) {
		for(int i = 0;  i < clientes.size(); i++) {
			if(clientes.elementAt(i).getMail().equals(mailIngresado))
				return true;
		}
		//Busco en la base de datos
		return AdmPersistenciaCliente.getInstancia().mailRepetido(mailIngresado);
	}

	public void crearCliente(String nombre, String apellido, String dni, String mail, String domicilio, String localidad,
			String codigoPostal) {
		// Las verificaciones de que el cliente ya existe se hacen en la pantala CrearCliente
		// cuando se verifica que el dni y mail ingresado no sean repetidos
		Cliente clienteNuevo = new Cliente(nombre, apellido, dni, mail, domicilio, localidad, codigoPostal);
		clientes.add(clienteNuevo);
		//inserto en la base de datos
		//clienteNuevo.insertarCliente(clienteNuevo); -> se hace en el constructor de cliente		
	}

	public Cliente buscarCliente(String dniIngresado) {
		//busco en memoria
		for(int i = 0; i < clientes.size(); i++) {
			if(clientes.elementAt(i).getDni().equals(dniIngresado))
				return clientes.elementAt(i);
		}
		//busco en la base de datos
		Cliente c = AdmPersistenciaCliente.getInstancia().buscarCliente(dniIngresado);
		if (c != null) return c;
		return null;
	}
	
	private static int getProximoNumero() {
		return ++codigoCalzado;
	}

	public static String getCodigoBota() {
		String codigo = Integer.toString(getProximoNumero()-1);
		return 'B'+ codigo;
	}
	public static String getCodigoZapatilla() {
		String codigo = Integer.toString(getProximoNumero()-1);
		return 'Z'+ codigo;
	}
	public static String getCodigoZapatoHombre() {
		String codigo = Integer.toString(getProximoNumero()-1);
		return "ZH"+ codigo;
	}
	public static String getCodigoZapatoMujer() {
		String codigo = Integer.toString(getProximoNumero()-1);
		return "ZM"+ codigo;
	}
	
}
