package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Negocio.Empleado;


public class AdmPersistenciaEmpleado implements AdministradorPersistencia<Empleado> {
	private static AdmPersistenciaEmpleado instancia;
	private String db;
	
	private AdmPersistenciaEmpleado(){
		db=PoolConnection.getPoolConnection().getNameDB();
	}
	
	public static AdmPersistenciaEmpleado getInstancia(){
		if(instancia==null)
			instancia=new AdmPersistenciaEmpleado();
		return instancia;
	}
	
	@Override
	public void insert(Empleado o) {//Funciona
		// TODO Auto-generated method stub	
		String sql="insert into "+db+".Empleado values (?,?,?,?,?,?,?,?)";
		Connection c=PoolConnection.getPoolConnection().getConnection();

		try{
			PreparedStatement ps=c.prepareStatement(sql);
			
			//////////////////////////////////////////////////////					
			ps.setString(1,o.getNombre());
			ps.setString(2,o.getApellido());
			ps.setString(3, o.getDni());
			ps.setString(4,o.getCuil());
			ps.setString(5,o.getDomicilio());
			ps.setString(6,o.getLocalidad());
			ps.setString(7,o.getTelefono());
			ps.setBoolean(8, o.isEstado());
			//////////////////////////////////////////////////////		
			
			ps.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Empleado o) {//Funciona
		// TODO Auto-generated method stub
		String sql="update "+db+".Empleado set estado=0 where dni="+o.getDni();
		Connection c=PoolConnection.getPoolConnection().getConnection();

		try{
			Statement s=c.createStatement();
			s.execute(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void update(Empleado o) {//Funciona
		// TODO Auto-generated method stub		
		String sql="update "+db+".Empleado set nombre=?, apellido=?, domicilio=?, localidad=?, telefono=? where dni=?";
		Connection c=PoolConnection.getPoolConnection().getConnection();

		try{
			PreparedStatement ps=c.prepareStatement(sql);
			
			//////////////////////////////////////////////////////			
			ps.setString(1,o.getNombre());
			ps.setString(2,o.getApellido());
			ps.setString(3,o.getDomicilio());
			ps.setString(4,o.getLocalidad());
			ps.setString(5,o.getTelefono());	
			ps.setString(6, o.getDni());
			//////////////////////////////////////////////////////		
			
			ps.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Empleado select(String id) {//Funciona
		// TODO Auto-generated method stub
		Empleado u=null;
		
		String sql="Select * from "+db+".Empleado where idEmpleado="+id;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		ResultSet rs;
	
		try{			
			Statement s=c.createStatement();
			rs=s.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			
			while( rs.next() ){
				u=new Empleado();
				u.setId(Integer.parseInt(id));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setDni(rs.getString(4));
				u.setCuil(rs.getString(5));
				u.setDomicilio(rs.getString(6));
				u.setLocalidad(rs.getString(7));
				u.setTelefono(rs.getString(8));
				u.setEstado(rs.getBoolean(9));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}

				
		return u;
	}
	
	@Override
	public  Vector<Empleado> selectAll() {//Funciona
		// TODO Auto-generated method stub
		 Vector<Empleado> lResultado=new  Vector<Empleado>();
		String sql="Select * from "+db+".Empleado where estado=1";
		Connection c=PoolConnection.getPoolConnection().getConnection();
		ResultSet rs;
				
		try{
			Statement s=c.createStatement();
			rs=s.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				Empleado u=new Empleado();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setDni(rs.getString(4));
				u.setCuil(rs.getString(5));
				u.setDomicilio(rs.getString(6));
				u.setLocalidad(rs.getString(7));
				u.setTelefono(rs.getString(8));
				u.setEstado(rs.getBoolean(9));
				
				lResultado.add(u);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return lResultado;
	}
 
	@Override
	public int getIdMaximo() {//Funciona
		// TODO Auto-generated method stub
		int id=0;
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		Statement s;
		String sql="Select Max(idEmpleado) from "+db+".Empleado";
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
