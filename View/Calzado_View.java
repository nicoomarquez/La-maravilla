package View;

import java.util.Vector;

import Negocio.Arreglo;

public class Calzado_View {
	private String codigo,tipoCalzado,costo;
	private char estado;
	private int idEmpleado;
	private Vector<Arreglo>arreglos;
	
	public Calzado_View(String codigo, String tipoCalzado, String costo, char estado, int idEmpleado,
			Vector<Arreglo> arreglos) {
		super();
		this.codigo = codigo;
		this.tipoCalzado = tipoCalzado;
		this.costo = costo;
		this.estado = estado;
		this.idEmpleado = idEmpleado;
		this.arreglos = arreglos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipoCalzado() {
		return tipoCalzado;
	}

	public void setTipoCalzado(String tipoCalzado) {
		this.tipoCalzado = tipoCalzado;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public char isEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public Vector<Arreglo> getArreglos() {
		return arreglos;
	}

	public void setArreglos(Vector<Arreglo> arreglos) {
		this.arreglos = arreglos;
	}
	
	
	
}
