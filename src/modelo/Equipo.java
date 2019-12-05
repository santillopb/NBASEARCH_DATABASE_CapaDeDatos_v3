package modelo;

import java.util.List;

public class Equipo {
	private int id;
	private String nombre;
	private List<Jugador> jugadores;
	
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
	
}
