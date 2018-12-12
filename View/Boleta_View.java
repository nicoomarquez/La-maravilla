package View;

import java.util.Vector;

public class Boleta_View {
	private int idBoleta;
	int idCliente;
	private String dniCliente,fecha;
	private float seña,total;
	private Vector<Calzado_View>calzadosView;
	private boolean estado;
	private char estadoRetiro;
	
	public Boleta_View(int idBoleta, int idCliente,String dniCliente, String fecha,
			float seña, float total,boolean estado,char estadoRetiro) {
		super();
		this.idBoleta = idBoleta;
		this.idCliente = idCliente;
		this.dniCliente = dniCliente;
		this.fecha = fecha;
		this.seña = seña;
		this.total = total;
		calzadosView=new Vector<Calzado_View>();
		this.estado=estado;
		this.estadoRetiro=estadoRetiro;
	}

	@Override
	public String toString(){
		
		
		return  idBoleta + " - Calzados: "+calzadosView.size()+ " - "+fecha +" - "+ estadoRetiro;
		
	}
	
	public int getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getSeña() {
		return seña;
	}

	public void setSeña(float seña) {
		this.seña = seña;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Vector<Calzado_View> getCalzadosView() {
		return calzadosView;
	}

	public void setCalzadosView(Vector<Calzado_View> calzadosView) {
		this.calzadosView = calzadosView;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public char getEstadoRetiro() {
		return estadoRetiro;
	}

	public void setEstadoRetiro(char estadoRetiro) {
		this.estadoRetiro = estadoRetiro;
	}
	
	
}
