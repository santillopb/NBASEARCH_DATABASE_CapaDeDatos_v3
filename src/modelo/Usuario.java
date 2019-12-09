package modelo;

public class Usuario {
	private int id;
	private String user;
	private String password;
	private String dni;
	private String nombre;
	
	public Usuario(int id, String user, String password) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
	}
	

	public Usuario(int id, String user, String password, String dni, String nombre) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.dni = dni;
		this.nombre = nombre;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
