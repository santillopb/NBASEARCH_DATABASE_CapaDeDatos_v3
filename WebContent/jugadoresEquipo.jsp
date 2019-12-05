<%@page import="modelo.Posicion"%>
<%@page import="modelo.Modelo"%>
<%@page import="modelo.Jugador"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  %>
	<h1><%=request.getParameter("equipo")%></h1>
	<table>
		<thead>
			<th>Nombre</th><th>Apellidos</th><th>Posicion</th><th>Altura</th><th>Peso</th><th>Dorsal</th>
		</thead>
		<tbody>
			<% 	Modelo m = new Modelo();
				List<Jugador> jugadores = m.getJugadoresPorEquipo(request.getParameter("equipo")); 
				
				for(Jugador j: jugadores) {
					// Creamos objeto posicion
					Posicion p = new Posicion();
					// Asignamos el idPosicion del objeto Jugador al objeto Posicion
					p.setId(j.getIdPosicion());
					
					// Creamos modelo
					Modelo m2 = new Modelo();
					// Creamos objeto y lo asignamos al modelo pasandole como parametro el objeto
					// anterior para obtener el nombre de la posicion
					Posicion p2 = m2.getPosicion(p);
				
				%>
					<tr>
						<td><%=j.getNombre() %></td>
						<td><%=j.getApellidos() %></td>
						<td><%=p2.getPosicion() %></td>
						<td><%=j.getAltura() %></td>
						<td><%=j.getPeso() %></td>
						<td><%=j.getDorsal() %></td>
					</tr>
				<%
				}
			%>
		</tbody>
	</table>
</body>
</html>