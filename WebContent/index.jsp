<!doctype html>
<%@page import="modelo.Posicion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Jugador"%>
<%@page import="modelo.Equipo"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Modelo"%>
<html lang="es-ES">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Landing</title>
    <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,700italic,400,300,700">
    <link rel="stylesheet" href="recursos/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="recursos/css/styles.css">
        <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md" style="background-color: rgb(247,153,66);">
        <div class="container-fluid"><a class="navbar-brand" href="#"><img src="recursos/img/Nuevo%20Dibujo%204.png" style="width: 78px;padding: 17px;margin: -46px;"><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;NBA Database</strong></a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item" role="presentation"><a><strong class="btn btn-success" id="login">Login</strong></a></li>
                    <li class="nav-item" role="presentation"><a><strong class="btn btn-success" id="registro">Sing In</strong></a></li>
                </ul>
        </div>
        </div>
    </nav>
    <div id="divJumbo">
        <div class="jumbotron">
            <h1>Base de datos NBA</h1>
            <p>Busca los jugadores o equipos que quieras, consulta sus estadísticas e incluso comprueba la clasificación en tiempo real gracias a NBA Database.</p>
            <p><a class="btn btn-primary text-dark" role="button" href="#" style="background-color: rgb(251,190,134);"><strong>Saber Más</strong></a></p>
        </div>
    </div>
    <div class="container">
        <h1 class="text-center" style="height: 95px;"><br>Base de datos NBA<br><br></h1>
        <p class="text-center" style="height: 95px;margin: 12px;"><br>Busca los jugadores o equipos que quieras, consulta sus estadísticas e incluso comprueba la clasificación en tiempo real gracias a NBA Database.<br><br></p>
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
    <div></div>
    <div>
        <div class="zona-oscura">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 text-center" id="divHeader"><i class="fa fa-star"></i>
                        <h4 class="text-center"><strong>Jugadores</strong></h4>
                        <p class="text-center">Gracias a nuestra base de datos podrás saber todo sobre los jugadores que desees, desde estadisticas hasta en que habilidades son mejores o peores.</p>
                    </div>
                    <div class="col-md-4 text-center" id="divHeader"><i class="fa fa-shield"></i>
                        <h4 class="text-center"><strong>Equipos</strong></h4>
                        <p class="text-center">Consulta las estadísticas de tu equipo favorito, mira su historial o comprueba la clasificación en tiempo real de los equipos de la mejor liga.</p>
                    </div>
                    <div class="col-md-4 text-center" id="divHeader"><i class="fa fa-plus"></i>
                        <h4 class="text-center"><strong>Crea</strong></h4>
                        <p class="text-center">Si estás registrado, puedes añadir tus propios jugadores a la página web y añadirlos a la base de datos.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="recursos/js/jquery.min.js"></script>
    <script src="recursos/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript">
		document.getElementById("login").addEventListener("click", function () {
			// Tenemos que crear el Servlet (Controlador) para mostrar la pag login
			location.href = "PaginaLogin";
		});
	</script>
	<script type="text/javascript">
		document.getElementById("registro").addEventListener("click", function () {
			// Tenemos que crear el Servlet (Controlador) para mostrar la pag login
			location.href = "PaginaRegistro";
		});

		document.getElementById("listaEquipos").addEventListener("change", function() {
			var selectedIndex = this.selectedIndex;
			var value = this.options[selectedIndex].value;
			location.href = "jugadoresEquipo.jsp?equipo="+value;
		});
	</script>      
  </body>
</html>
