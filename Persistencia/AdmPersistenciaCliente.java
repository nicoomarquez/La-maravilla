package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import Negocio.Cliente;

public class AdmPersistenciaCliente implements AdministradorPersistencia<Cliente> {
	private static AdmPersistenciaCliente instancia=null;
	private String db;
	
	private AdmPersistenciaCliente(){
		db=PoolConnection.getPoolConnection().getNameDB();
	}
	
	public static AdmPersistenciaCliente getInstancia(){
		if(instancia==null)
			instancia=new AdmPersistenciaCliente();
		return instancia;
	}
	
	@Override
	public void insert(Cliente o) {//Funciona
		// TODO Auto-generated method stub
		String sql="insert into "+db+".Cliente values (?,?,?,?,?,?,?,?)";
		Connection c=PoolConnection.getPoolConnection().getConnection();

		try{
			PreparedStatement ps=c.prepareStatement(sql);
			
			//////////////////////////////////////////////////////					
			ps.setString(1,o.getNombre());
			ps.setString(2,o.getApellido());
			ps.setString(3, o.getMail());
			ps.setString(4,o.getDni());
			ps.setString(5,o.getDomicilio());
			ps.setString(6,o.getLocalidad());
			ps.setString(7,o.getCodigoPostal());
			ps.setBoolean(8, true);
			//////////////////////////////////////////////////////		
			
			ps.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
		}catch(Exception e){
			System.out.println(e.getMessage()+"\n"+e.getMessage());
		}
	}

	@Override
	public void delete(Cliente o) {//Funciona
		// TODO Auto-generated method stub
		String sql="update "+db+".Cliente set estado=0 where idCliente="+o.getId();
		Connection c=PoolConnection.getPoolConnection().getConnection();

		try{
			Statement s=c.createStatement();
			s.execute(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
		
		}catch(Exception e){
			System.out.println(e.getMessage()+"\n"+e.getMessage());
		}
	}

	@Override
	public void update(Cliente o) {//Funciona
		// TODO Auto-generated method stub
		String sql="update "+db+".Cliente set nombre=?, apellido=?, domicilio=?, localidad=?, email=?, codigoPostal=? where dni=?";
		Connection c=PoolConnection.getPoolConnection().getConnection();

		try{
			PreparedStatement ps=c.prepareStatement(sql);
			
			//////////////////////////////////////////////////////			
			ps.setString(1,o.getNombre());
			ps.setString(2,o.getApellido());
			ps.setString(3,o.getDomicilio());
			ps.setString(4,o.getLocalidad());
			ps.setString(5,o.getMail());	
			ps.setString(6,o.getCodigoPostal());
			ps.setString(7,o.getDni());
			//////////////////////////////////////////////////////		
			
			ps.execute();
			PoolConnection.getPoolConnection().realeaseConnection(c);
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	/**Es el mismo metodo que buscarCliente() pero este lo hace desde el idCliente*/
	@Override
	public Cliente select(String id) {//Funciona
		Cliente c = null;
		ResultSet result;
		Connection con;
		try
		{			
			con = PoolConnection.getPoolConnection().getConnection();
			//busco clientes activos
			PreparedStatement ps = con.prepareStatement("select * from "+db+".Cliente where idCliente = ? and estado = 1");			
			//agregar campos
			ps.setString(1, id);
			result = ps.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			while (result.next())
			{
				String nom = result.getString(2);
				String ape = result.getString(3);
				String mail = result.getString(4);
				String doc = result.getString(5);
				String dom = result.getString(6);
				String loc = result.getString(7);
				String codPostal = result.getString(8);
				boolean estado=result.getBoolean(9);
				//c = new Cliente(nom, ape, doc, mail, dom, loc, codPostal); -> no es este constructor, aca se inserta en la bd
				c=new Cliente();
				c.setId(Integer.parseInt(id));
				c.setNombre(nom);
				c.setApellido(ape);
				c.setMail(mail);
				c.setDni(doc);
				c.setDomicilio(dom);
				c.setLocalidad(loc);
				c.setCodigoPostal(codPostal);
				c.setEstado(estado);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public  Vector<Cliente> selectAll() {//Funciona
		// TODO Auto-generated method stub
		 Vector<Cliente> lResultado=new  Vector<Cliente>();
		String sql="Select * from "+db+".Cliente where estado=1";
		Connection c=PoolConnection.getPoolConnection().getConnection();
		ResultSet rs;
				
		try{
			Statement s=c.createStatement();
			rs=s.executeQuery(sql);
			PoolConnection.getPoolConnection().realeaseConnection(c);
			while(rs.next()){
				Cliente u=new Cliente();
				u.setId(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setMail(rs.getString(4));
				u.setDni(rs.getString(5));				
				u.setDomicilio(rs.getString(6));
				u.setLocalidad(rs.getString(7));
				u.setCodigoPostal(rs.getString(8));
				u.setEstado(rs.getBoolean(9));
				
				lResultado.add(u);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return lResultado;

	}

	public boolean dniRepetido(String dni) {//Funciona + correccion
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			//busco si hay algún cliente con el dni ingresado
			PreparedStatement s = con.prepareStatement("select * from "+db+".Cliente where dni = ?");
			
			/*Santi, te saque el estado=1 porque a nosotros nos importa saber si el ñato existe en el sistema
			 * este dado de baja o no.*/
			
			//agregar campos
			s.setString(1, dni);
			ResultSet result = s.executeQuery(); //ResultSet es una tabla
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			return result.next(); //si la consulta CONTIENE alguna tabla
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public Cliente buscarCliente(String dni)//Funciona
	{
		Cliente c = null;
		ResultSet result;
		Connection con;
		try
		{			
			con = PoolConnection.getPoolConnection().getConnection();
			//busco clientes activos
			PreparedStatement s = con.prepareStatement("select * from "+db+".Cliente where dni = ? and estado = 1");			
			//agregar campos
			s.setString(1, dni);
			result = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			while (result.next())
			{
				int id=result.getInt(1);
				String nom = result.getString(2);
				String ape = result.getString(3);
				String mail = result.getString(4);
				String doc = result.getString(5);
				String dom = result.getString(6);
				String loc = result.getString(7);
				String codPostal = result.getString(8);
				boolean estado=result.getBoolean(9);
				//c = new Cliente(nom, ape, doc, mail, dom, loc, codPostal); -> no es este constructor, aca se inserta en la bd
				c=new Cliente();
				c.setId(id);
				c.setNombre(nom);
				c.setApellido(ape);
				c.setMail(mail);
				c.setDni(doc);
				c.setDomicilio(dom);
				c.setLocalidad(loc);
				c.setCodigoPostal(codPostal);
				c.setEstado(estado);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	public boolean mailRepetido(String mail) {
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			//busco si hay algún cliente con el mail ingresado
			PreparedStatement s = con.prepareStatement("select * from "+db+".Cliente where email = ?");// and estado = 1			
			//agregar campos
			s.setString(1, mail);
			PoolConnection.getPoolConnection().realeaseConnection(con);
			ResultSet result = s.executeQuery(); //ResultSet es una tabla
			
			return result.next();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int getIdMaximo() {//Funciona
		// TODO Auto-generated method stub
		int id=-1;
		ResultSet rs;
		Connection c=PoolConnection.getPoolConnection().getConnection();
		Statement s;
		String sql="Select Max(idCliente) from "+db+".Cliente";
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
