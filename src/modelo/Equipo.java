package modelo;

import java.io.InputStream;
import java.util.List;

public class Equipo {
	private int id;
	private int idConferencia;
	private int idDivision;
	private String nombre;
	private List<Jugador> jugadores;
	private InputStream inputStream;

	private String base64foto;
	
	public Equipo(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Equipo(int id, String nombre, List<Jugador> jugadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.jugadores = jugadores;
	}

	
	public Equipo(int id, int idConferencia, int idDivision, String nombre, List<Jugador> jugadores) {
		super();
		this.id = id;
		this.idConferencia = idConferencia;
		this.idDivision = idDivision;
		this.nombre = nombre;
		this.jugadores = jugadores;
	}

	
	public Equipo(int id, int idConferencia, int idDivision, String nombre, List<Jugador> jugadores,
			InputStream inputStream) {
		super();
		this.id = id;
		this.idConferencia = idConferencia;
		this.idDivision = idDivision;
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.inputStream = inputStream;
	}

	public Equipo(int id, int idConferencia, int idDivision, String nombre, List<Jugador> jugadores,
			String base64foto) {
		super();
		this.id = id;
		this.idConferencia = idConferencia;
		this.idDivision = idDivision;
		this.nombre = nombre;
		this.jugadores = jugadores;
		this.base64foto = base64foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public int getIdConferencia() {
		return idConferencia;
	}

	public void setIdConferencia(int idConferencia) {
		this.idConferencia = idConferencia;
	}

	public int getIdDivision() {
		return idDivision;
	}

	public void setIdDivision(int idDivision) {
		this.idDivision = idDivision;
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
