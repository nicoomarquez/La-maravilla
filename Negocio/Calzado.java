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
	
	private int codigoZapatilla,codigoBota, codigoZH, codigoZM;
	private static int autoZapatilla,autoBota,autoZH,autoZM;
	
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
		return new Calzado_View(codigoCalzado,"",String.valueOf(costoCalzado),estado,empleado.getIdEmpleado(),arreglos);
	}
	
	public static void iniciarAutoNumerico(int nro, String cat){
		switch(cat){
			case "B": autoBota=nro;
				break;
			case "Z": autoZapatilla=nro;
				break;
			case "ZH" : autoZH=nro;
				break;
			case "ZM": autoZM=nro;
				break;
			default: System.out.println("Categoria incorrecta");
		}
	}
	
	/**Dado la categoria te devuelve el supuesto id que va a tener, no modifica el autonumerico*/
	public String getCodigoSinIncrementar(String cat){
		String res="";
		switch(cat){
			case "B": 
				if(autoBota==0) res=cat+(autoBota+1);
				else res=cat+autoBota;
				
				break;
			case "Z": if(autoZapatilla==0)res=cat+(autoZapatilla+1);
					  else res=cat+autoZapatilla;
				break;
			case "ZH" : 
					  if(autoZH==0) res=cat+(autoZH+1);
					  else res=cat+autoZH;
				break;
			case "ZM": 
					  if(autoZM==0) res=cat+(autoZH+1);
					  else res=cat+autoZM;
				break;
			default: System.out.println("Categoria incorrecta");
		}
		return res;
	}
	
	public String getCodigo(String cat){
		String res="";
		switch(cat){
			case "B": res=cat+(++autoBota);
				break;
			case "Z": res=cat+(++autoZapatilla);
				break;
			case "ZH" : res=cat+(++autoZH);
				break;
			case "ZM": res=cat+(++autoZM);
				break;
			default: System.out.println("Categoria incorrecta");
		}
		return res;
	}
}
