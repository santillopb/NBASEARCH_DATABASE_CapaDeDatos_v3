<%@page import="modelo.Equipo"%>
<%@page import="modelo.Posicion"%>
<%@page import="modelo.Jugador"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Modelo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
        <div class="container"><a class="navbar-brand" href="#"><img src="recursos/img/Nuevo Dibujo 4.png" id="icono" style="width: 78px;padding: 17px;margin: -46px;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;NBA Database</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="equipos.jsp"><strong>Equipos</strong></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="clasificacion.html" style="margin: 0px;"><strong>Clasificación</strong></a></li>
                </ul>
                <form class="form-inline border rounded float-right mr-auto" target="_self">
                    <div class="form-group float-right"><label for="search-field"></label><input class="form-control search-field" type="search" name="search" id="search-field" style="background-color: rgb(255,187,124);margin: 1px;padding: 11px;"><i class="fa fa-search" style="margin: 12px;"></i></div>
                </form><a class="btn btn-light action-button" role="button" href="#">Log Out</a></div>
        </div>
    </nav>
    <div id="divInfo">
        <div class="container">
            <div class="row">
            	<% 	Modelo m3 = new Modelo();
					Equipo e = m3.getEquipoConImagen(request.getParameter("equipo")); 
				%>
                <div class="col-md-6 text-center"><img src="data:image/jpeg;base64,<%=e.getBase64foto() %>" alt="<%=request.getParameter("equipo") %>" id="imagenEquipos" style="width: 250px;height: 250px;"></div>
                <div class="col-md-6">
                    <p style="margin: 15px;"><br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante augue, tristique et tristique ac, laoreet sed eros. Sed venenatis tincidunt tortor, non volutpat neque ultrices eu. Nam non dui tincidunt, euismod neque ac, porta
                        ex. Sed nec consequat ipsum, id posuere diam. Sed et arcu finibus, pellentesque lectus et, varius metus. Mauris sed dui a nunc iaculis eleifend congue vel libero. Ut molestie pellentesque orci, sed pellentesque ante ornare vel.
                        Sed venenatis tincidunt tortor, non volutpat neque ultrices eu.&nbsp;Sed venenatis tincidunt tortor, non volutpat neque ultrices eu.&nbsp;<br></p>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin: 0px;">
        <div class="col" id="divTablas" style="padding: 34px;">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Posición</th>
                            <th>Altura</th>
                            <th>Peso</th>
                            <th>Dorsal</th>
                        </tr>
                    </thead>
                    <tbody>
						<%	Modelo m = new Modelo();
						List<Jugador> jugadores = m.getJugadoresPorEquipoConImagen(request.getParameter("equipo")); 
						
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
									<td>
										<a href="verfichaJugador.jsp?jugador=<%=j.getId() %>">
											<img src="data:image/jpeg;base64,<%=j.getBase64foto() %>" alt="<%=j.getNombre() + " " + j.getApellidos() %>" style="width: 54px;height: 40px;"><%=j.getNombre() + " " + j.getApellidos() %>
										</a>
									</td>
									<td><%=p2.getPosicion() %></td>
									<td><%=j.getAltura() %></td>
									<td><%=j.getPeso() %></td>
									<td><%=j.getDorsal() %></td>
								</tr>
							<%
						}
						%>
						<!-- tr>
                            <td>Pancracio Tontito</td>
                            <td>Pivot</td>
                            <td>212</td>
                            <td>150.000$</td>
                        </tr>
                        <tr>
                            <td>Henks Ahrm</td>
                            <td>Wing</td>
                            <td>201</td>
                            <td>164.500$</td>
                        </tr>
                        <tr>
                            <td>Hung Lao</td>
                            <td>Wing</td>
                            <td>190</td>
                            <td>128.000$</td>
                        </tr-->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="recursos/js/jquery.min.js"></script>
    <script src="recursos/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>