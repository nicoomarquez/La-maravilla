package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import Negocio.Cliente;

public class AdmPersistenciaCliente extends AdministradorPersistencia {
	
	private static AdmPersistenciaCliente instancia;
	
	private AdmPersistenciaCliente()
	{	
	}
	
	public static AdmPersistenciaCliente getInstancia()
	{
		if (instancia == null)
			instancia = new AdmPersistenciaCliente();
		return instancia;
	}

	@Override
	public void insert(Object o) {
		try
		{
			Cliente c = (Cliente)o;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into SARA.dbo.Cliente values (?,?,?,?,?,?,?,?)");
			//agregar campos
			s.setString(1, c.getNombre());
			s.setString(2, c.getApellido());
			s.setString(3, c.getMail());
			s.setString(4, c.getDni());
			s.setString(5, c.getDomicilio());
			s.setString(6, c.getLocalidad());
			s.setString(7, c.getCodigoPostal());
			s.setBoolean(8, c.isEstado());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector<Object> select(Object o) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Cliente buscarCliente(String dni)
	{
		try
		{
			Cliente c = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			//busco clientes activos
			PreparedStatement s = con.prepareStatement("select * from SARA.dbo.Cliente where dni = ? and estado = 1");			
			//agregar campos
			s.setString(1, dni);
			ResultSet result = s.executeQuery();
			while (result.next())
			{
				String nom = result.getString(1);
				String ape = result.getString(2);
				String mail = result.getString(3);
				String doc = result.getString(4);
				String dom = result.getString(5);
				String loc = result.getString(6);
				String codPostal = result.getString(7);
				c = new Cliente(nom, ape, doc, mail, dom, loc, codPostal);
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return c;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean dniRepetido(String dni) {
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			//busco si hay algún cliente con el dni ingresado
			PreparedStatement s = con.prepareStatement("select * from SARA.dbo.Cliente where dni = ? and estado = 1");			
			//agregar campos
			s.setString(1, dni);
			ResultSet result = s.executeQuery(); //ResultSet es una tabla
			if (result.next()) //si la consulta me devuelve una tabla
			{
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return true;
			}
			else {
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean mailRepetido(String mail) {
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			//busco si hay algún cliente con el mail ingresado
			PreparedStatement s = con.prepareStatement("select * from SARA.dbo.Cliente where email = ? and estado = 1");			
			//agregar campos
			s.setString(1, mail);
			ResultSet result = s.executeQuery(); //ResultSet es una tabla
			if (result.next()) //si la consulta me devuelve una tabla
			{	
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return true;
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
