package modelo;

public class Jugador {
	private int id;
	private int idEquipo;
	private String nombre;
	private String apellidos;
	private int idPosicion;
	private double altura;
	private double peso;
	private int dorsal;
	
	public Jugador(int id, int idEquipo, String nombre, String apellidos, int idPosicion, double altura, double peso, int dorsal) {
		super();
		this.id = id;
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idPosicion = idPosicion;
		this.altura = altura;
		this.peso = peso;
		this.dorsal = dorsal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public int getDorsal() {
		return dorsal;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public int getIdPosicion() {
		return idPosicion;
	}
	
	public void setIdPosicion(int idPosicion) {
		this.idPosicion = idPosicion;
	}
}
