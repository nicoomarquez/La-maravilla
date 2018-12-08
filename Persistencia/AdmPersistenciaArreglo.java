package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import Negocio.Arreglo;

public class AdmPersistenciaArreglo implements AdministradorPersistencia<Arreglo> {
	private static AdmPersistenciaArreglo instancia=null;
	private String db;
	
	private AdmPersistenciaArreglo(){
		db=PoolConnection.getPoolConnection().getNameDB();
	}
	
	public static AdmPersistenciaArreglo getInstancia() {
		// TODO Auto-generated method stub
		if(instancia==null)
			instancia=new AdmPersistenciaArreglo();
		return instancia;
	}
	
	
	@Override
	public void insert(Arreglo o) {//Funciona
		Connection c=PoolConnection.getPoolConnection().getConnection();
		PreparedStatement s;
		String sql="insert into "+db+".Arreglo (nombre,descripcion,costoArreglo) values (?,?,?)";
		try{
			s=c.prepareStatement(sql);
			s.setString(1, o.getNombre());
			s.setString(2, o.getDescripcion());
			s.setFloat(3, o.getCostoArreglo());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Arreglo o) {
		// TODO Auto-generated method stub
		System.out.println("delete a implementar");
	}

	@Override
	public void update(Arreglo o) {
		// TODO Auto-generated method stub
		System.out.println("update a implementar");
	}

	@Override
	/**Busca un arreglo especifico desde su ID*/
	public Arreglo select(String id) {//Funciona
		// TODO Auto-generated method stub
		Arreglo arreglo=null;
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="Select * from "+db+".Arreglo where idArreglo="+id;
		try{
			Statement st=c.createStatement();
			rs=st.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				arreglo=new Arreglo();
				String nombre=rs.getString(2);
				String desc=rs.getString(3);
				float costo=rs.getFloat(4);
				boolean estado=rs.getBoolean(5);
				
				arreglo.setCostoArreglo(costo);
				arreglo.setDescripcion(desc);
				arreglo.setNombre(nombre);
				arreglo.setEstado(estado);
			}
		}catch(Exception e){
			e.printStackTrace();			
		}
		return arreglo;
	}

	@Override
	/**Busca todos los arreglos existentes en el sistema*/
	public  Vector<Arreglo> selectAll() {//Funciona
		// TODO Auto-generated method stub
		Vector<Arreglo> arr=new Vector<Arreglo>();
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="Select * from "+db+".Arreglo";
		try{
			Statement s=c.createStatement();
			rs=s.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				int idArr=rs.getInt(1);
				Arreglo arreglo=new Arreglo();
				arreglo.setCostoArreglo(rs.getFloat(4));
				arreglo.setDescripcion(rs.getString(3));
				arreglo.setIdArreglo(idArr);
				arreglo.setNombre(rs.getString(2));
				arreglo.setEstado(rs.getBoolean(5));
				arr.add(arreglo);
			}
		}catch(Exception e){
			e.printStackTrace();			
		}
		return arr;
	}

	/**Busca todos los arreglos asociados a un codigo de calzado*/
	public Vector<Arreglo> selectAll(String codigo) {//Funciona
		// TODO Auto-generated method stub
		Vector<Arreglo> arr=new Vector<Arreglo>();
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		String sql="Select idArreglo from "+db+".ArregloCalzado where codigoCalzado=?";
		try{
			PreparedStatement s=c.prepareStatement(sql);
			s.setString(1, codigo);
			rs=s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				String idArr=rs.getString(1);
				Arreglo arreglo=select(idArr);
				arr.add(arreglo);
			}
		}catch(Exception e){
			e.printStackTrace();			
		}
		return arr;
	}
	
	public void insert(String codigo, Vector<Arreglo> arreglos){//Funciona
		Connection c=PoolConnection.getPoolConnection().getConnection();
		PreparedStatement s;
		String sql="insert into "+db+".ArregloCalzado values(?,?)";
		try{
			s=c.prepareStatement(sql);
			s.setString(2, codigo);
			for(Arreglo a:arreglos){
				s.setInt(1, a.getIdArreglo());
				s.execute();
			}
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int getIdMaximo() {//Funciona
		// TODO Auto-generated method stub
		int id=-1;
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		Statement s;
		String sql="Select Max(idArreglo) from "+db+".Arreglo";
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
