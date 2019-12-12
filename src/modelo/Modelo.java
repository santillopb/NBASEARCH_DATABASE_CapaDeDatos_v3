package modelo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Modelo
 */
@Stateless
@LocalBean
public class Modelo {
	private List<Equipo> equipos;	// Consultar los equipos
	private List<Jugador> jugadores;	// Consultar los jugadores
	private Posicion posicion;	// Consultar una posicion
	private Usuario usuario;	// Consultar o insertar un usuario
	private Equipo equipo;		// Insertar un equipo
	private Jugador jugador;	// Insertar un jugador
    /**
     * Default constructor. 
     */
    public Modelo() {
        // TODO Auto-generated constructor stub
    }
    
    // Consultar los equipos
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
	
	// Consultar los equipos con imagen escudo
		public List<Equipo> getEquiposConImagen() throws IOException {
			DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
			
			try {
				ResultSet rs = db.dameEquipos();
				equipos = new ArrayList<Equipo>();
				while(rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					Blob blob = rs.getBlob("escudo");
					
					InputStream inputStream = blob.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					
					while((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
					
					byte[] imageBytes = outputStream.toByteArray();
					
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					
					inputStream.close();
					outputStream.close();
					
					equipo = new Equipo(id, nombre);
					equipo.setBase64foto(base64Image);
					equipos.add(equipo);
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
				int id = rs.getInt("jugadoractual.id");
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
	
	//Metodo que devuelve lista de jugadores con imagen por idEquipo por parametro
		public List<Jugador> getJugadoresPorEquipoConImagen(String nombreEquipo) throws IOException {
			// Conectamos a la base de datos
			DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
			
			// Asignamos memoria a la lista jugadores
			jugadores = new ArrayList<>();
			try {
				// Llamamos al ResultSet dameJugadores
				ResultSet rs = db.dameJugadores(nombreEquipo);
				
				// Recorremos el ResultSet
				while(rs.next()) {
					int id = rs.getInt("jugadoractual.id");
					int idEquipo = rs.getInt("idEquipo");
					String nombre = rs.getString("jugadoractual.nombre");
					String apellidos = rs.getString("apellidos");
					int idPosicion = rs.getInt("idPosicion");
					double altura = rs.getDouble("altura");
					double peso = rs.getDouble("peso");
					int dorsal = rs.getInt("dorsal");
					Blob blob = rs.getBlob("foto");
					
					if(blob != null) {
						InputStream inputStream = blob.getBinaryStream();
						ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
						byte[] buffer = new byte[4096];
						int bytesRead = -1;
						
						while((bytesRead = inputStream.read(buffer)) != -1) {
							outputStream.write(buffer, 0, bytesRead);
						}
						
						byte[] imageBytes = outputStream.toByteArray();
						
						String base64Image = Base64.getEncoder().encodeToString(imageBytes);
						
						inputStream.close();
						outputStream.close();
						
						jugador = new Jugador(id, idEquipo, nombre, apellidos, idPosicion, altura, peso, dorsal);
						jugador.setBase64foto(base64Image);
						// Rellenamos la lista de jugadores
						jugadores.add(jugador);
					} else {
						jugador = new Jugador(id, idEquipo, nombre, apellidos, idPosicion, altura, peso, dorsal);
						// Rellenamos la lista de jugadores
						jugadores.add(jugador);
					}
					
					
					

					
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
	
	// Consultar la posicion
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
	
	// Consultar usuario
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
	
	// Insertar usuario
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

	// Consultar equipos por conferencia
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
    
 // Consultar equipos por conferencia con imagen escudo
    public List<Equipo> equiposPorConferenciaConImagen(int idConferencia) throws IOException{
    	DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
    	equipos = new ArrayList<Equipo>();
    	try {
			ResultSet rs = db.dameEquiposPorConferencia(idConferencia);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Blob escudo = rs.getBlob("escudo");
				
				// Si la imagen es null llamaremos al constructor sin imagen
				// y si es diferente llamaremos al constructor sin imagen y
				// al setter de la imagen
				if(escudo != null) {
					InputStream inputStream = escudo.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					
					while((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
					
					byte[] imageBytes = outputStream.toByteArray();
					
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					
					inputStream.close();
					outputStream.close();
					
					equipo = new Equipo(id, nombre);
					equipo.setBase64foto(base64Image);
				} else {
					equipo = new Equipo(id, nombre);
				}
				equipos.add(equipo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return equipos;
    }

	public Equipo getEquipo() {
		return equipo;
	}
	
	public Equipo getEquipoConImagen(String nombreEquipo) throws IOException {
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		try {
			ResultSet rs = db.dameEquipo(nombreEquipo);
			// Devuelve un usuario
			if(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				Blob escudo = rs.getBlob("escudo");
				
				if(escudo != null) {
					InputStream inputStream = escudo.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					
					while((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
					
					byte[] imageBytes = outputStream.toByteArray();
					
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					
					inputStream.close();
					outputStream.close();
					
					equipo = new Equipo(id, nombre);
					equipo.setBase64foto(base64Image);
				} else {
					equipo = new Equipo(id, nombre);
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		try {
			db.insertaEquipo(this.equipo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Jugador getJugador() {
		return jugador;
	}
	
	// Consultar el jugador con imagen con el id del jugador
	public Jugador getJugadorConImagen(int idJugador) throws IOException {
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		try {
			ResultSet rs = db.dameJugador(idJugador);
			// Devuelve un usuario
			if(rs.next()) {
				int id = rs.getInt("jugadoractual.id");
				int idEquipo = rs.getInt("idEquipo");
				String nombre = rs.getString("jugadoractual.nombre");
				String apellidos = rs.getString("apellidos");
				int idPosicion = rs.getInt("idPosicion");
				double altura = rs.getDouble("altura");
				double peso = rs.getDouble("peso");
				int dorsal = rs.getInt("dorsal");
				Blob blob = rs.getBlob("foto");
				
				if(blob != null) {
					InputStream inputStream = blob.getBinaryStream();
					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int bytesRead = -1;
					
					while((bytesRead = inputStream.read(buffer)) != -1) {
						outputStream.write(buffer, 0, bytesRead);
					}
					
					byte[] imageBytes = outputStream.toByteArray();
					
					String base64Image = Base64.getEncoder().encodeToString(imageBytes);
					
					inputStream.close();
					outputStream.close();
					
					jugador = new Jugador(id, idEquipo, nombre, apellidos, idPosicion, altura, peso, dorsal);
					jugador.setBase64foto(base64Image);
				} else {
					jugador = new Jugador(id, idEquipo, nombre, apellidos, idPosicion, altura, peso, dorsal);
				}
			}
			
			} catch (SQLException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return jugador;
		}
			
	

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
		DataBaseConnection db = new DataBaseConnection("sllop", "Temp2019$$");
		try {
			db.insertaJugador(this.jugador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    
}
