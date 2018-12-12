package Negocio;

import java.util.Vector;

import Persistencia.AdmPersistenciaCalzado;
import View.Calzado_View;

public class Calzado {
	private String codigoCalzado;
	private Vector<Arreglo> arreglos;
	private float costoCalzado;
	private Empleado empleado;
	private char estado;
	
	public Calzado(){
		arreglos = new Vector<Arreglo>();
		empleado = new Empleado();		
	}
	
	public Calzado(String codigoCalzado, float costoCalzado, Empleado empleado, Vector<Arreglo> arreglos) {
		super();
		this.codigoCalzado = codigoCalzado;
		this.costoCalzado = costoCalzado;
		this.empleado = empleado;
		this.arreglos = arreglos;
		this.estado = 'P';//estado pendiente
		/*Se inserta en la BD*/
		AdmPersistenciaCalzado.getInstancia().insert(this);
	}

	public String getCodigoCalzado() {
		return codigoCalzado;
	}

	public void setCodigoCalzado(String codigoCalzado) {
		this.codigoCalzado = codigoCalzado;
	}

	public Vector<Arreglo> getArreglos() {
		return arreglos;
	}

	public void setArreglos(Vector<Arreglo> arreglos) {
		this.arreglos = arreglos;
	}

	public float getCostoCalzado() {
		return costoCalzado;
	}

	public void setCostoCalzado(float costoCalzado) {
		this.costoCalzado = costoCalzado;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	public char getEstado(){
		return estado;
	}
	
	public void setEstado(char e){
		this.estado=e;
	}

	public void update(){
		AdmPersistenciaCalzado.getInstancia().update(this);
	}
	
	public void delete(){
		AdmPersistenciaCalzado.getInstancia().delete(this);
	}

	public Calzado_View toView() {
		// TODO Auto-generated method stub
		return new Calzado_View(codigoCalzado,codigoCalzado.substring(0, 2),String.valueOf(costoCalzado),estado,empleado.getIdEmpleado(),arreglos);
	}
}
