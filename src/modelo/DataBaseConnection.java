package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataBaseConnection {
	private String user;
	private String password;
	private Connection conn;
	
	public DataBaseConnection(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}
	
	public Connection getConnection() throws ClassNotFoundException {
		conn = null;
		Properties infoConnection;
		String urlConnection;
		
		urlConnection = "jdbc:mysql://localhost:3306/nba";
		infoConnection = new Properties();
		infoConnection.put("user", this.user);
		infoConnection.put("password", this.password);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(urlConnection, infoConnection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	// Recupera equipos
		public ResultSet dameEquipos() throws SQLException {
			ResultSet rs = null;
			String query = "select * from equipo";
			
			Statement stmt;
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}

		public ResultSet dameJugadores(int idEquipo) throws SQLException {
			ResultSet rs = null;
			
			String query = "SELECT * FROM nba.jugadoractual WHERE idEquipo = ?";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, idEquipo);
				rs = stmt.executeQuery();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}

		public ResultSet dameJugadores(String nombreEquipo) throws SQLException {
			ResultSet rs = null;
			
			String query = "SELECT * FROM nba.equipo, nba.jugadoractual "
					+ "where equipo.id = jugadoractual.idEquipo and "
					+ "equipo.nombre = ?";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setString(1, nombreEquipo);
				rs = stmt.executeQuery();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		
		// Consultar la posicion por id
		public ResultSet damePosicion(Posicion p) throws SQLException {
			ResultSet rs = null;
			
			String query = "SELECT * FROM nba.posicion WHERE id = ?";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, p.getId());
				rs = stmt.executeQuery();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}

		public ResultSet dameUsuario(Usuario u) throws SQLException {
			ResultSet rs = null;
			
			String query = "SELECT * FROM nba.login "
					+ "WHERE user = ? AND password = ?";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setString(1, u.getUser());
				stmt.setString(2, u.getPassword());
				rs = stmt.executeQuery();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		
		
		

		public ResultSet dameEquiposPorConferencia(int idConferencia) throws SQLException {
			ResultSet rs = null;
			
			String query = "SELECT * FROM nba.equipo WHERE idConferencia=?";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, idConferencia);
				rs = stmt.executeQuery();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
		}

		public void insertaUsuario(Usuario u) throws SQLException {
			// TODO Auto-generated method stub			
			String query = "INSERT INTO `nba`.`login` (`user`, `password`, `dni`, `nombre`)"
					+ " VALUES (?, ?, ?, ?)";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setString(1, u.getUser());
				stmt.setString(2, u.getPassword());
				stmt.setString(3, u.getDni());
				stmt.setString(4, u.getNombre());
				stmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		// Insertar un equipo
		public void insertaEquipo(Equipo eq) throws SQLException {
			// TODO Auto-generated method stub
			String query = "INSERT INTO `nba`.`equipo` (`idConferencia`, `idDivision`, `nombre`)"
					+ " VALUES (?, ?, ?);";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, eq.getIdConferencia());
				stmt.setInt(2, eq.getIdDivision());
				stmt.setString(3, eq.getNombre());
				stmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Insertar un jugador
		public void insertaJugador(Jugador j) throws SQLException {
			// TODO Auto-generated method stub
			String query = "INSERT INTO `nba`.`jugadoractual` "
					+ "(`idEquipo`, `nombre`, `apellidos`, `idPosicion`, `altura`, `peso`, `dorsal`)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?)"; 
					
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, j.getIdEquipo());
				stmt.setString(2, j.getNombre());
				stmt.setString(3, j.getApellidos());
				stmt.setInt(4, j.getIdPosicion());
				stmt.setDouble(5, j.getAltura());
				stmt.setDouble(6, j.getPeso());
				stmt.setInt(7, j.getDorsal());
				stmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Consultar un equipo con imagen
		public ResultSet dameEquipo(String nombreEquipo) throws SQLException {
			ResultSet rs = null;
			
			String query = "SELECT * FROM nba.equipo WHERE nombre = ?";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setString(1, nombreEquipo);
				rs = stmt.executeQuery();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}

		public ResultSet dameJugador(int idJugador) throws SQLException {
			ResultSet rs = null;
			
			String query = "SELECT * FROM nba.jugadoractual WHERE id = ?";
			
			PreparedStatement stmt;
			
			try {
				conn = getConnection();
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, idJugador);
				rs = stmt.executeQuery();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}

		

}
