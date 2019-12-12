<%@page import="modelo.Modelo"%>
<%@page import="modelo.Jugador"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>PlantillaJugador</title>
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
        <div class="container"><a class="navbar-brand" href="#"><img src="recursos/img/Nuevo%20Dibujo%204.png" id="icono" style="width: 78px;padding: 17px;margin: -46px;">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;NBA Database</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav text-justify d-md-flex mr-auto justify-content-md-start">
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#"><strong>Equipos</strong></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#" style="margin: 0px;"><strong>Clasificación</strong></a></li>
                </ul>
                <form class="form-inline border rounded float-right mr-auto" target="_self">
                    <div class="form-group float-right"><label for="search-field"></label><input class="form-control search-field" type="search" name="search" id="search-field" style="background-color: rgb(255,187,124);margin: 1px;padding: 11px;"><i class="fa fa-search" style="margin: 12px;"></i></div>
                </form><a class="btn btn-light action-button" role="button" href="#">Log Out</a></div>
        </div>
    </nav>
    <div id="divInfo">
        <div class="container">
            <div class="row">
            	<% 	Modelo m = new Modelo();
            		int id = Integer.parseInt(request.getParameter("jugador").toString());
            		Jugador j = m.getJugadorConImagen(id); %>
                <div class="col-md-6 text-center"><img src="data:image/jpeg;base64,<%=j.getBase64foto() %>" id="imagenJugador" style="width: 260px;height: 190px;"></div>
                <div class="col-md-6">
                    <h3 id="nombreJugador"><%=j.getNombre() + " " + j.getApellidos() %></h3>
                    <p style="margin: 15px;"><br>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla ante augue, tristique et tristique ac, laoreet sed eros. Sed venenatis tincidunt tortor, non volutpat neque ultrices eu. Nam non dui tincidunt, euismod neque ac, porta
                        ex. Sed nec consequat ipsum, id posuere diam. Sed et arcu finibus, pellentesque lectus et, varius metus. Mauris sed dui a nunc iaculis eleifend congue vel libero. Ut molestie pellentesque orci, sed pellentesque ante ornare vel.
                        Sed venenatis tincidunt tortor, non volutpat neque ultrices eu.&nbsp;Sed venenatis tincidunt tortor, non volutpat neque ultrices eu.&nbsp;<br></p>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin: 0px;">
        <div class="col" id="divTablas" style="padding: 34px;">
            <div class="table-responsive" id="estadisticasJugador">
                <table class="table">
                    <thead>
                        <tr>
                            <th>Temporadas</th>
                            <th>P/J</th>
                            <th>Puntos</th>
                            <th>Lo que sea</th>
                            <th>Lo que sea 2</th>
                            <th>Equipos</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>16/17</td>
                            <td>20</td>
                            <td>212</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <td>17/18</td>
                            <td>21</td>
                            <td>201</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <td>18/19</td>
                            <td>20</td>
                            <td>190</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                        </tr>
                        <tr>
                            <td>19/20</td>
                            <td>13</td>
                            <td>160</td>
                            <td>1</td>
                            <td>1</td>
                            <td>1</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>