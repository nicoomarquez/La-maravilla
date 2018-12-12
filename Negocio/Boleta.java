package Negocio;

import java.sql.Date;
import java.util.Vector;

import Persistencia.AdmPersistenciaBoleta;
import View.Boleta_View;
import View.Calzado_View;

public class Boleta {
	private int idBoleta;
	private static int autonumerico;
	private Cliente cliente;
	private float total, seña;
	private Date fecha;
	private Vector<Calzado> calzados;
	private boolean estado;
	private char estadoRetiro;
	
	public Boleta() {
		// TODO Auto-generated constructor stub
		cliente = new Cliente();
		calzados = new Vector<Calzado>();
	}

	public Boleta(Cliente cliente, float total, float seña, Date fecha, Vector<Calzado> calzados) {
		super();
		idBoleta = getProxNum();
		this.cliente = cliente;
		this.total = total;
		this.seña = seña;
		this.fecha = fecha;
		this.calzados = calzados;
		this.estadoRetiro = 'P';
		this.estado = true;
		
		AdmPersistenciaBoleta.getInstancia().insert(this);
	}

	private static int getProxNum() {
		// TODO Auto-generated method stub
		return ++autonumerico;
	}

	public int getIdBoleta() {
		return idBoleta;
	}
	
	public void setIdBoleta(int num){
		idBoleta=num;
	}

	public static void iniciarAutoNumerico(int valorInicial){
		autonumerico=valorInicial;
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

	public float getSeña() {
		return seña;
	}

	public void setSeña(float seña) {
		this.seña = seña;
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

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public char getEstadoRetiro(){
		return this.estadoRetiro;
	}
	
	public void setEstadoRetiro(char estado){
		this.estadoRetiro=estado;
	}
	
	public void update(){
		AdmPersistenciaBoleta.getInstancia().update(this);
	}
	
	public void delete(){
		AdmPersistenciaBoleta.getInstancia().delete(this);
	}
	/*int idBoleta, int idCliente,String dniCliente, String fecha,
			float seña, float total,boolean estado,char estadoRetiro*/
	public Boleta_View toView(){
		Boleta_View bv=new Boleta_View(idBoleta,cliente.getId(),cliente.getDni(),fecha.toString(),seña,total,estado,estadoRetiro);
		Vector<Calzado_View>cvs=new Vector<Calzado_View>();
		for(Calzado c:calzados)
			cvs.add(c.toView());
		bv.setCalzadosView(cvs);
		return bv;
	}
}
