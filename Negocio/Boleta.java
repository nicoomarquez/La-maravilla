package Negocio;

import java.sql.Date;
import java.util.Vector;

public class Boleta {
	private int idBoleto;
	private Cliente cliente;
	private float total, se�a;
	private Date fecha;
	private Vector<Calzado> calzados;
	private char estado;
	
	public Boleta() {
		// TODO Auto-generated constructor stub
		cliente= new Cliente();
		calzados= new Vector<Calzado>();
	}

	public Boleta(int idBoleto, Cliente cliente, float total, float se�a, Date fecha, Vector<Calzado> calzados,
			char estado) {
		super();
		this.idBoleto = idBoleto;
		this.cliente = cliente;
		this.total = total;
		this.se�a = se�a;
		this.fecha = fecha;
		this.calzados = calzados;
		this.estado = estado;
		
		//insert en DB
	}

	public int getIdBoleto() {
		return idBoleto;
	}

	public void setIdBoleto(int idBoleto) {
		this.idBoleto = idBoleto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getSe�a() {
		return se�a;
	}

	public void setSe�a(float se�a) {
		this.se�a = se�a;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Vector<Calzado> getCalzados() {
		return calzados;
	}

	public void setCalzados(Vector<Calzado> calzados) {
		this.calzados = calzados;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
	
	
	

}
