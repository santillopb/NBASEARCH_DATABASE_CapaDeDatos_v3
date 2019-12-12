package modelo;

import java.io.InputStream;

public class Jugador {
	private int id;
	private int idEquipo;
	private String nombre;
	private String apellidos;
	private int idPosicion;
	private double altura;
	private double peso;
	private int dorsal;
	private InputStream inputStream;

	private String base64foto;
	
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

	
	public Jugador(int id, int idEquipo, String nombre, String apellidos, int idPosicion, double altura, double peso,
			int dorsal, InputStream inputStream, String base64foto) {
		super();
		this.id = id;
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idPosicion = idPosicion;
		this.altura = altura;
		this.peso = peso;
		this.dorsal = dorsal;
		this.inputStream = inputStream;
	}

	public Jugador(int id, int idEquipo, String nombre, String apellidos, int idPosicion, double altura, double peso,
			int dorsal, String base64foto) {
		super();
		this.id = id;
		this.idEquipo = idEquipo;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idPosicion = idPosicion;
		this.altura = altura;
		this.peso = peso;
		this.dorsal = dorsal;
		this.base64foto = base64foto;
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


	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public String getBase64foto() {
		return base64foto;
	}


	public void setBase64foto(String base64foto) {
		this.base64foto = base64foto;
	}
	
	
}
