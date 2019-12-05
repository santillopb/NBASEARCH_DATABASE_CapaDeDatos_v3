package modelo;

import java.util.List;

public class Posicion {
	private int id;
	private String posicion;
	
	
	public Posicion() {
		// TODO Auto-generated constructor stub
	}
	public Posicion(int id, String posicion) {
		super();
		this.id = id;
		this.posicion = posicion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
}
