package Negocio;

public class Arreglo {
	private static int idArreglo;
	private String nombre;
	private String descripcion;
	private float costoArreglo;
	
	public Arreglo(){
		idArreglo = 0;
		nombre = "";
		descripcion = "";
		costoArreglo = 0f;
	}

	public Arreglo(String nombre, String descripcion, float costoArreglo) {
		super();
		idArreglo = getProxNumArreglo();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costoArreglo = costoArreglo;
		
		/*Persistencia Arreglo insert*/
	}

	private static int getProxNumArreglo() {
		return ++idArreglo;
	}
/*
	public void setIdArreglo(int idArreglo) {
		this.idArreglo = idArreglo;
	}*/

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
	
	
}
