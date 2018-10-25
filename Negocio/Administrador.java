package Negocio;

public class Administrador {
	private String nombreUsuario, contrasenia;
	
	public Administrador(String nombreUsuario, String contrasenia) {
		// TODO Auto-generated constructor stub
		this.nombreUsuario=nombreUsuario;
		this.contrasenia=contrasenia;
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
