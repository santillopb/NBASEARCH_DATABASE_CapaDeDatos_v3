package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Modelo
 */
@Stateless
@LocalBean
public class Modelo {
	private List<Equipo> equipos;
	private List<Jugador> jugadores;
	private Posicion posicion;
	private Usuario usuario;
    /**
     * Default constructor. 
     */
    public Modelo() {
        // TODO Auto-generated constructor stub
    }
	public List<Equipo> getEquipos() {
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		
		try {
			ResultSet rs = db.dameEquipos();
			equipos = new ArrayList<Equipo>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				equipos.add(new Equipo(id, nombre));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return equipos;
	}
	
	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}
	public List<Equipo> getJugadoresPorEquipo() {
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		
		try {
			// Asignamos memoria lista equipos
			equipos = new ArrayList<Equipo>();
			// Llamamos al ResultSet dameEquipos
			ResultSet rsEquipo = db.dameEquipos();
			// Recorremos ResultSet dameEquipos
			while(rsEquipo.next()) {
				int idEquipo = rsEquipo.getInt("id");
				String nombreEquipo = rsEquipo.getString("nombre");
				
				// Llamamos al ResultSet dameJugadores con parametro idEquipo
				ResultSet rsJugador = db.dameJugadores(idEquipo);
				// Asignamos memoria lista jugadores
				jugadores = new ArrayList<Jugador>();
				// Recorremos ResultSet dameJugadores
				while(rsJugador.next()) {
					int idJugador = rsJugador.getInt("id");
					String nombreJugador = rsJugador.getString("nombre");
					String apellidos = rsJugador.getString("apellidos");
					int idPosicion = rsJugador.getInt("idPosicion");
					double altura = rsJugador.getDouble("altura");
					double peso = rsJugador.getDouble("peso");
					int dorsal = rsJugador.getInt("dorsal");
					
					
					
					// Llenamos la lista de jugadores
					jugadores.add(new Jugador(idJugador, idEquipo, nombreJugador, apellidos, idPosicion, altura, peso, dorsal));
				}
				// Llenamos la lista de equipos
				equipos.add(new Equipo(idEquipo, nombreEquipo, jugadores));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return equipos;
	}
	
	//Metodo que devuelve lista de jugadores por idEquipo por parametro
	public List<Jugador> getJugadoresPorEquipo(String nombreEquipo) {
		// Conectamos a la base de datos
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		
		// Asignamos memoria a la lista jugadores
		jugadores = new ArrayList<>();
		try {
			// Llamamos al ResultSet dameJugadores
			ResultSet rs = db.dameJugadores(nombreEquipo);
			
			// Recorremos el ResultSet
			while(rs.next()) {
				int id = rs.getInt("id");
				int idEquipo = rs.getInt("idEquipo");
				String nombre = rs.getString("jugadoractual.nombre");
				String apellidos = rs.getString("apellidos");
				int idPosicion = rs.getInt("idPosicion");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				int dorsal = rs.getInt("dorsal");
				
				// Rellenamos la lista de jugadores
				jugadores.add(new Jugador(id, idEquipo, nombre, apellidos, idPosicion, altura, peso, dorsal));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jugadores;
	}
	
	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	public Posicion getPosicion(Posicion p) {
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		try {
			ResultSet rs = db.damePosicion(p);
			if(rs.next()) {
				int id = rs.getInt("id");
				String nombrePosicion = rs.getString("posicion");
				posicion = new Posicion(id, nombrePosicion);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return posicion;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}
	public Usuario getUsuario(Usuario u) {
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		try {
			ResultSet rs = db.dameUsuario(u);
			// Devuelve un usuario
			if(rs.next()) {
				int id = rs.getInt("id");
				String user = rs.getString("user");
				String password = rs.getString("password");
				usuario = new Usuario(id, user, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		try {
			db.insertaUsuario(this.usuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

    public List<Equipo> equiposPorConferencia(int idConferencia){
    	DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
    	equipos = new ArrayList<Equipo>();
    	try {
			ResultSet rs = db.dameEquiposPorConferencia(idConferencia);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				
				equipos.add(new Equipo(id, nombre));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return equipos;
    }
}
