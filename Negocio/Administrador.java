package Negocio;

public class Administrador {
	private String nombreUsuario, contrasenia;
	
	public Administrador(String nombreUsuario, String contrasenia){//para validar login
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public Administrador() {
		// TODO Auto-generated constructor stub
		this.nombreUsuario="admin";
		this.contrasenia="admin";
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}
