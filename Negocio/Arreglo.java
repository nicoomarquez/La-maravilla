package Negocio;

import Persistencia.AdmPersistenciaArreglo;

public class Arreglo {
	private int idArreglo;
	private static int autonumerico;
	private String nombre;
	private String descripcion;
	private float costoArreglo;
	private boolean estado;
	
	public Arreglo(){

	}

	public Arreglo(String nombre, String descripcion, float costoArreglo) {
		super();
		idArreglo = getProxNumArreglo();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoArreglo = costoArreglo;
		this.estado=true;
		
		/*Persistencia Arreglo insert*/
		AdmPersistenciaArreglo.getInstancia().insert(this);
	}

	private static int getProxNumArreglo() {
		return ++autonumerico;
	}

	public static void iniciarAutoNumerico(int valorInicial){
		autonumerico=valorInicial;
	}
	
	public int getIdArreglo(){
		return idArreglo;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getCostoArreglo() {
		return costoArreglo;
	}

	public void setCostoArreglo(float costoArreglo) {
		this.costoArreglo = costoArreglo;
	}

	public void setEstado(boolean estado) {
		// TODO Auto-generated method stub
		this.estado=estado;
	}
	
	public boolean getEstado(){
		return this.estado;
	}
	
	public void setIdArreglo(int idArr) {
		// TODO Auto-generated method stub
		idArreglo=idArr;
	}
	
	public void update(){
		AdmPersistenciaArreglo.getInstancia().update(this);
	}
	
	public void delete(){
		AdmPersistenciaArreglo.getInstancia().delete(this);
	}

	
}
