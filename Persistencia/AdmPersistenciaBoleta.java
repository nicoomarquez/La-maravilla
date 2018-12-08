package Persistencia;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import Negocio.Boleta;
import Negocio.Calzado;
import Negocio.Cliente;
import View.Boleta_View;

public class AdmPersistenciaBoleta implements AdministradorPersistencia<Boleta> {
	private static AdmPersistenciaBoleta instancia=null;
	private String db;
	
	private AdmPersistenciaBoleta(){
		db=PoolConnection.getPoolConnection().getNameDB();
	}
	
	public static AdmPersistenciaBoleta getInstancia(){
		if(instancia==null)
			instancia=new AdmPersistenciaBoleta();
		return instancia;
	}
	
	@Override
	public void insert(Boleta o) {//Funciona
		// TODO Auto-generated method stub
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="insert into "+db+".Boleta (idCliente, total,seña, fecha) values (?,?,?,?)";
		try{
			PreparedStatement s=c.prepareStatement(sql);
			s.setInt(1, o.getCliente().getId());
			s.setFloat(2, o.getTotal());
			s.setFloat(3, o.getSeña());
			s.setDate(4, o.getFecha());
			
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
			
			/*Inserto los calzados en boletaCalzado*/
			
			insert(o.getIdBoleta(),o.getCalzados());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void insert(int idBoleta, Vector<Calzado> calzados) {//Funciona
		// TODO Auto-generated method stub
		Connection c=PoolConnection.getPoolConnection().getConnection();
		PreparedStatement s;
		String sql="insert into "+db+".BoletaCalzado values(?,?)";
		try{
			s=c.prepareStatement(sql);
			s.setInt(1, idBoleta);
			for(Calzado calzado:calzados){
				s.setString(2, calzado.getCodigoCalzado());
				s.execute();
			}
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Boleta o) {//Funciona
		// TODO Auto-generated method stub
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="update "+db+".Boleta set estado=0 where idBoleta="+o.getIdBoleta();
		try{
			Statement s=c.createStatement();
			s.execute(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	/**Se actualiza unicamente el estadoRetiro de la boleta*/
	public void update(Boleta o) {//Funciona
		// TODO Auto-generated method stub
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="update "+db+".Boleta set estadoRetiro='"+o.getEstadoRetiro()+"' where idBoleta="+o.getIdBoleta();
		try{
			Statement s=c.createStatement();
			s.execute(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	/**Busco una boleta desde su idBoleta*/
	public Boleta select(String id) {//Funciona
		// TODO Auto-generated method stub
		Connection c=PoolConnection.getPoolConnection().getConnection();
		ResultSet rs;
		String sql="select * from "+db+".Boleta where idBoleta="+id;
		Boleta b=null;
		try{
			Statement st=c.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()){
				b=new Boleta();
				b.setEstadoRetiro(rs.getString("estadoRetiro").charAt(0));
				b.setEstado(rs.getBoolean("estado"));
				b.setFecha(rs.getDate("fecha"));
				b.setSeña(rs.getFloat("seña"));
				b.setTotal(rs.getFloat("total"));
				b.setIdBoleta(Integer.parseInt(id));
				
				/*
				 **************************************
				 *  Recupero el cliente y el calzado  *
				 **************************************/
				String idCliente=rs.getString("idCliente");
				Cliente cli=AdmPersistenciaCliente.getInstancia().select(idCliente);
				Vector<Calzado> calzados=AdmPersistenciaCalzado.getInstancia().selectAll(id);
				
				b.setCliente(cli);
				b.setCalzados(calzados);
			}
		}catch(Exception e){
			e.printStackTrace();
		}	
		return b;
	}

	@Override
	
	public  Vector<Boleta> selectAll() {
		// TODO Auto-generated method stub
		System.out.println("selectAll boleta a implementar");
		return new  Vector<Boleta>();
	}
	
	/**Busco todas las boletas de un cliente conociendo su dni. 
	 * Como este metodo se usa en la vista, se devuelve un Boleta_View para no
	 * buscar todos los objetos que involucran una boleta. 
	 * @see Boleta_View*/
	public Vector<Boleta_View> buscarBoletasCliente(String dniCliente) {//Funciona
		// TODO Auto-generated method stub
		Vector<Boleta_View> bv=new Vector<Boleta_View>();
		Connection c=PoolConnection.getPoolConnection().getConnection();
		ResultSet rs;
		int idBuscado=AdmPersistenciaCliente.getInstancia().buscarCliente(dniCliente).getId();
		String sql="select * from "+db+".Boleta where idCliente="+idBuscado;
		try{
			Statement s=c.createStatement();
			rs=s.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				int idBoleta=rs.getInt(1);
				float total=rs.getFloat(3);
				float seña=rs.getFloat(4);
				String fecha=rs.getDate(5).toString();
				char estadoR=rs.getString(6).charAt(0);
				boolean estado=rs.getBoolean(7);
				
				Boleta_View b=new Boleta_View(idBoleta,idBuscado,dniCliente,fecha,seña,total,estado,estadoR);
				b.setCalzadosView(AdmPersistenciaCalzado.getInstancia().selectAllToView(idBoleta));
				bv.add(b);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bv;
	}

	@Override
	public int getIdMaximo() {//Funciona
		// TODO Auto-generated method stub
		int id=-1;
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		Statement s;
		String sql="Select Max(idBoleta) from "+db+".Boleta";
		try{
			s=c.createStatement();
			rs=s.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			if(rs.next())
				id=rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

}
