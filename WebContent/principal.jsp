<%@page import="modelo.Posicion"%>
<%@page import="modelo.Jugador"%>
<%@page import="modelo.Equipo"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Modelo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>PaginaEquipo</title>
    <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="recursos/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="recursos/fonts/ionicons.min.css">
    <link rel="stylesheet" href="recursos/css/Footer-Dark.css">
    <link rel="stylesheet" href="recursos/css/Highlight-Clean.css">
    <link rel="stylesheet" href="recursos/css/Navigation-with-Search.css">
    <link rel="stylesheet" href="recursos/css/styles-1.css">
    <link rel="stylesheet" href="recursos/css/styles.css">
</head>
<body>
	<nav class="navbar navbar-light navbar-expand-md navigation-clean-search" style="background-color: rgb(247,153,66);">
        <div class="container"><a class="navbar-brand" href="#"><img src="recursos/img/Nuevo%20Dibujo%204.png" id="icono" style="width: 78px; padding: 17px; margin: -46px;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;NBA Database</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="equipos.jsp"><strong>Equipos</strong></a></li>                    
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#" style="margin: 0px;"><strong>Clasificación</strong></a></li>
                </ul>
                <form class="form-inline border rounded float-right mr-auto" target="_self">
                    <div class="form-group float-right"><label for="search-field"></label><input class="form-control search-field" type="search" name="search" id="search-field" style="background-color: rgb(255,187,124);margin: 1px;padding: 11px;"><i class="fa fa-search" style="margin: 12px;"></i></div>
                </form><a class="btn btn-light action-button" role="button" href="#" id="logout">Log Out</a></div>
        </div>
    </nav>
	<p>
		Bienvenido ${sessionScope.user}
	</p>
	<p id="demo"></p>
	
	<div class="container">
		<table border="2">
    		<thead>
    			<tr>
    				<th>Lista de Equipos</th>
    				<th colspan="6">Lista de Jugadores</th>
    			</tr>
    		</thead>
    		<tbody>
    			<% Modelo m = new Modelo();
    			   List<Equipo> equipos = m.getJugadoresPorEquipo();
    			   for(Equipo e: equipos) {
    				   List<Jugador> jugadores = e.getJugadores();
    				   if(jugadores.size() == 0) {
    					   %><tr>
   				   				<td><%=e.getNombre() %></td><td colspan="6"></td>
   				     		 </tr>
   				     	   <%
    				   } else{
    					   %>
    					   <tr>
    					   		<td rowspan="<%=jugadores.size()+1 %>"><%=e.getNombre() %></td>
    					   		<th>Nombre</th><th>Apellidos</th><th>Posicion</th><th>Altura</th><th>Peso</th><th>Dorsal</th>
    					   </tr>
    					   <%  
				   			for(Jugador j: jugadores) {
				   				// Creamos el objeto posicion
				   				Posicion p = new Posicion();
				   				// Asignamos el idPosicion del objeto jugador al Id del objeto posicion
				   				p.setId(j.getIdPosicion());
				   				// Llamamos al modelo para que rellene el nombre de la posicion
				   				Posicion p2 = m.getPosicion(p);
				   			
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
				   		
    				   }
    				   
    				     	
    				   	 
    				  
    				 }
    			   %>
    			
    		</tbody>
    	</table>
    	
    	<table border="2">
    		<thead>
    			<tr>
    				<th>Lista de Equipos</th>
    			</tr>
    		</thead>
    		<tbody>
    			<% 
    				for(Equipo e: equipos) {
    					%>
    						<tr>
    							<td><a href="jugadoresEquipo.jsp?equipo=<%=e.getNombre()  %>"><%=e.getNombre() %></a></td>
    						</tr>
    					<%
    				}
    			%>
    		</tbody>
    	</table>
    	<select id="listaEquipos">
    		<option></option>
    		<% 
    				for(Equipo e: equipos) {
    					%>
    					
    						<option value="<%=e.getNombre() %>"><%=e.getNombre() %></option>
    					<%
    				}
    			%>
    	</select>
	</div>
    <script src="recursos/js/jquery.min.js"></script>
    <script src="recursos/bootstrap/js/bootstrap.min.js"></script>
	<script>
		function myFunction() {
			var d = new Date();
			var n = d.toUTCString();
			document.getElementById("demo").innerHTML = n;
		}

		window.onload = function() {
			window.setInterval(myFunction, 999);
		};
	</script>
	<script>
		document.getElementById("logout").addEventListener("click", function() {
			location.href = "PrincipalController";
		});
		document.getElementById("listaEquipos").addEventListener("change", function() {
			var selectedIndex = this.selectedIndex;
			var value = this.options[selectedIndex].value;
			location.href = "jugadoresEquipo.jsp?equipo="+value;
		});
	</script>
</body>
</html>