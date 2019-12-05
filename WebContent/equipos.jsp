<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>equipos</title>
    <link rel="stylesheet" href="recursos/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="recursos/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="recursos/css/Highlight-Clean.css">
    <link rel="stylesheet" href="recursos/css/Navigation-with-Search.css">
    <link rel="stylesheet" href="recursos/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-search" style="background-color: rgb(247,153,66);">
        <div class="container"><a class="navbar-brand" href="#"><img src="recursos/img/Nuevo%20Dibujo%204.png" id="icono">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;NBA Database</a><button class="navbar-toggler" data-toggle="collapse" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav">
                    <li class="nav-item" role="presentation"><a class="nav-link active" href="#"><strong>Equipos</strong></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#"><strong>Link 2</strong></a></li>
                    <li class="nav-item" role="presentation"><a class="nav-link" href="#" style="margin: 0px;"><strong>Clasificación</strong></a></li>
                </ul>
                <form class="form-inline border rounded float-right mr-auto" target="_self">
                    <div class="form-group float-right"><label for="search-field"></label><input class="form-control search-field" type="search" name="search" id="search-field" style="background-color: rgb(255,187,124);margin: 1px;padding: 11px;"><i class="fa fa-search" style="margin: 12px;"></i></div>
                </form><a class="btn btn-light action-button" role="button" href="#">Log Out</a></div>
        </div>
    </nav>
    <div class="highlight-clean">
        <div  style="text-align: center" class="container">
            <div class="intro">
                <h2 class="text-center">CONFERENCIAS</h2>
                <p class="text-center">Elige una conferencia que mostrará los equipos de dicha conferencia para poder acceder a mas datos de los mismos.</p>
            </div>
            <div class="buttons">
		            <a class="btn btn-danger" role="button" href="#conferencia1" aria-expanded="false" aria-controls="collapseExample" data-toggle="collapse">Conferencia Oeste</a>
		            <a class="btn btn-danger" role="button" href="#conferencia2" aria-expanded="false" aria-controls="collapseExample" data-toggle="collapse">Conferencia Este</a>
            </div>
        </div>
    </div>
    <div class="text-center collapse" id="conferencia1" class="collapse">
        <div class="container">
            <div class="row">
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/atlanta.png" style="width: 115px;margin: 12px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/boston.png" style="width: 115px;margin: 13px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/BUCKS.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/nets.jpeg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/hornets.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/NY.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/detroit.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/ORLANDO.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/FILADELFIA.jpg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/indiana.jpg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/washinton.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/raptors.jpg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><a href="chicagoBulls.jsp"><img src="recursos/img/bulls.jpeg" style="width: 115px;margin: 9px;"></a></div>
                <div class="col-6 col-sm-4 col-md-4"><a href="clevelandCavaliers.jsp"><img src="recursos/img/cleveland.png" style="width: 115px;margin: 13px;"></a></div>
                <div class="col-6 col-sm-4 col-md-4"><a href="miamiHeat.jsp">"<img src="recursos/img/miamiHeat.png" style="width: 115px;"></a></div>
                >
            </div>
        </div>
    </div>
    <div class="text-center collapse" id="conferencia2" style="margin: 12px;padding: 0px;" class="collapse">
        <div class="container">
            <div class="row">
                <div class="col-6 col-sm-4 col-md-4" style="width: 115px;"><img src="recursos/img/goldenstate-1.jpg" style="width: 115px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/dalas.jpeg" style="width: 115px;margin: 9px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/HOUSTON.png" style="width: 115px;margin: 4px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/menphis.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/SPURS.jpg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/denver.jpeg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/MINESOTA.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/OKLAHOMA.jpeg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/PORTLAND.jpg" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/laclipers.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/suns.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/SACRAMENTO.png" style="width: 115px;margin: 6px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/PELICANS.png" style="width: 115px;"></div>
                <div class="col-6 col-sm-4 col-md-4"><a href="lalakers.jsp"><img src="recursos/img/lalakers.jpg" style="width: 115px;"></a></div>
                <div class="col-6 col-sm-4 col-md-4"><img src="recursos/img/UTAH.jpeg" style="width: 115px;"></div>
            </div>
        </div>
    </div>
    <div class="text-center"></div>
    <script src="recursos/js/jquery.min.js"></script>
    <script src="recursos/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>