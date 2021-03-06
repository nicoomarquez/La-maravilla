package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Negocio.Arreglo;
import Negocio.Calzado;
import Negocio.Empleado;
import View.Calzado_View;

public class AdmPersistenciaCalzado implements AdministradorPersistencia<Calzado> {
	private static AdmPersistenciaCalzado instancia;
	private String db;
	
	public static AdmPersistenciaCalzado getInstancia() {
		// TODO Auto-generated method stub
		if(instancia==null)
			instancia=new AdmPersistenciaCalzado();
		return instancia;
	}
	
	private AdmPersistenciaCalzado(){
		 db=PoolConnection.getPoolConnection().getNameDB();
	}
	
	@Override
	public void insert(Calzado o) {//Funciona
		// TODO Auto-generated method stub
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="Insert into "+db+".Calzado (codigoCalzado, costoCalzado,idEmpleado,estado) values (?,?,?,?)";
		try{
			String codigo=o.getCodigoCalzado();
			float costo=o.getCostoCalzado();
			int idEmpleado=o.getEmpleado().getIdEmpleado();
			String estado=String.valueOf(o.getEstado());
			
			PreparedStatement ps=c.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setFloat(2, costo);
			ps.setInt(3,idEmpleado);
			ps.setString(4,estado);
			
			ps.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
			
			//Insertar en la tabla ArregloCalzado (codigoCalzado, idArreglo)
			AdmPersistenciaArreglo.getInstancia().insert(codigo,o.getArreglos()); 
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Calzado o) {
		// TODO Auto-generated method stub
		/*Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="update "+db+".Calzado set estado=0 where codigoCalzado="+o.getCodigoCalzado();*/
		System.out.println("Delete calzado a implementar");
	}

	@Override
	public void update(Calzado o) {//Funciona
		// TODO Auto-generated method stub
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="update "+db+".Calzado set estado=? where codigoCalzado=?";
		
		try{
			PreparedStatement s=c.prepareStatement(sql);
			s.setString(1, String.valueOf(o.getEstado()));
			s.setString(2, o.getCodigoCalzado());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	/**Busco un calzado desde un codigoCalzado*/
	public Calzado select(String id) {//Funciona
		// TODO Auto-generated method stub
		Calzado calzado=null;
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="select * from "+db+".Calzado where codigoCalzado= ?";
		try{
			PreparedStatement st=c.prepareStatement(sql);
			st.setString(1,id);
			rs=st.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				float costo=rs.getFloat(2);
				String idEmpleado=rs.getString(3);
				char estado=rs.getString(4).charAt(0);
				
				/*
				 ****************************************
				 *  Recupero los arreglos y el empleado *
				 ****************************************/
				Vector<Arreglo>arreglos=AdmPersistenciaArreglo.getInstancia().selectAll(id);
				Empleado e=AdmPersistenciaEmpleado.getInstancia().select(idEmpleado);
				
				 calzado=new Calzado();
				 calzado.setArreglos(arreglos);
				 calzado.setCostoCalzado(costo);
				 calzado.setEmpleado(e);
				 calzado.setEstado(estado);
				 calzado.setCodigoCalzado(id);	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return calzado;
	}

	@Override
	public  Vector<Calzado> selectAll() {
		// TODO Auto-generated method stub
		System.out.println("SelectAll calzado a implementar");
		return null;
	}

	/** Busca todos los calzados asociados en una boleta*/
	public Vector<Calzado> selectAll(String idBoleta) {//Funciona
		// TODO Auto-generated method stub
		Vector<Calzado> calzados=new Vector<Calzado>();
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="select * from "+db+".BoletaCalzado where idBoleta="+idBoleta;
		try{
			Statement s=c.createStatement();
			rs=s.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				String codigo=rs.getString(2);
				calzados.add(select(codigo));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return calzados;
	}

	public int getidMaximo(String categoria){	
		
		int id=0;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		ResultSet rs;
		PreparedStatement s;
		String sql="Select codigoCalzado from "+db+".Calzado where codigoCalzado like ? order by 1 desc";
		
		try{
			s=c.prepareStatement(sql);
			s.setString(1, "%" + categoria + "%");
			rs=s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(c);
			if(!categoria.equals("Z")){//Si es Z me busca tambien los ZH y ZM
				if(rs.next()){
					String codigo=rs.getString(1);
					
					id=Integer.parseInt(codigo.substring(categoria.length()));
				}
			}
			else{
				while(rs.next()){
					String codigo=rs.getString(1);
					if(!codigo.contains("M")&&!codigo.contains("H")){
					
						id=Integer.parseInt(codigo.substring(categoria.length()));
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return id;
}

	public Vector<Calzado_View> selectAllToView(int idBoleta) {//Funciona
		// TODO Auto-generated method stub
		Vector<Calzado_View> cv=new Vector<Calzado_View>();
		
		Vector<Calzado>calzados=this.selectAll(String.valueOf(idBoleta));
		for(Calzado c:calzados)
			cv.add(c.toView());
		return cv;
	}

	@Override
	public int getIdMaximo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
