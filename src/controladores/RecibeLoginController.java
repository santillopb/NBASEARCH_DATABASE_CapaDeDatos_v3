package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Modelo;
import modelo.Usuario;

/**
 * Servlet implementation class RecibeLoginController
 */
@WebServlet("/RecibeLoginController")
public class RecibeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecibeLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		HttpSession sesion = request.getSession();
		
		Usuario usuario = new Usuario(0, user, password);
		Modelo m = new Modelo();
		Usuario u = m.getUsuario(usuario);
		
	
		//si coincide usuario y password y además no hay sesión iniciada
		if(u != null && sesion.getAttribute("user") == null) {
			sesion.setAttribute("user", user);
			request.getRequestDispatcher("loginExito.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
	}

}
