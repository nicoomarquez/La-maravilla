package Negocio;

import java.util.Vector;

public class Calzado {
	private int idCalzado;
	private Vector<Arreglo> arreglos;
	private float costoCalzado;
	private Empleado empleado;
	private char estado;
	
	public Calzado(){
		arreglos=new Vector<Arreglo>();
		empleado=new Empleado();		
	}
	
	public Calzado(int idCalzado, float costoCalzado, Empleado empleado, Vector<Arreglo> arreglos) {
		super();
		this.idCalzado = idCalzado;
		this.costoCalzado = costoCalzado;
		this.empleado = empleado;
		this.arreglos=arreglos;
		this.estado='P';//estado pendiente
		/*Se inserta en la BD*/
	}
	
	
	public int getIdCalzado() {
		return idCalzado;
	}

	public void setIdCalzado(int idCalzado) {
		this.idCalzado = idCalzado;
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
}
