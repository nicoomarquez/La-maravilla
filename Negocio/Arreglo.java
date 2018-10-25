package Negocio;

public class Arreglo {
	private int idArreglo;
	private String descripcion;
	private float costoArreglo;
	
	public Arreglo(){
		idArreglo=0;
		descripcion="";
		costoArreglo=0f;
	}

	public Arreglo(int idArreglo, String descripcion, float costoArreglo) {
		super();
		this.idArreglo = idArreglo;
		this.descripcion = descripcion;
		this.costoArreglo = costoArreglo;
		
		/*Persistencia Arreglo insert*/
	}

	public int getIdArreglo() {
		return idArreglo;
	}

	public void setIdArreglo(int idArreglo) {
		this.idArreglo = idArreglo;
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
