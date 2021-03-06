<%-- 
    Document   : index
    Created on : 21/03/2016, 09:42:34 AM
    Author     : acerpc
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/style.css"  > 
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
  


        <title>Pagina principal</title>
    </head>
    <body>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#dropdownvehicle").dropdown();
            });
        </script>
        <!-- <div class="container">
                     <a href="javascript:history.back()"><img src="<?php echo base_url()?>/img/atras.png" height="40" width="60" alt="Botón"/></a>
                     <a href="javascript:history.go(1)"><img src="<?php echo base_url()?>/img/adelante.png" height="43" width="66" alt="Botón"/></a>
         </div><br/>-->
        <div class="container-well">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                </ol>

                <!-- Wrapper for slides-->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">
                        <img src="img/car1.jpg" alt="Image">
                        <div class="carousel-caption">
                        </div>      
                    </div>

                    <div class="item">
                        <img src="img/car2.png" alt="Image">
                        <div class="carousel-caption">
                        </div>      
                    </div>
                </div> 

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>    
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="clientInformation.jsp"  role="button" aria-haspopup="true" aria-expanded="false">Clientes </a></li>
                            <li class="dropdown">
                                <a href="#" id="dropdownvehicle" class="dropdown-toggle" data-toggle="dropdown" role="button">Vehiculos <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="vehicleInformation.jsp">Añadir</a></li>
                                    <li><a href="vehicleSearch.jsp">Buscar </a></li>
                                </ul>
                            </li>
                            <li><a href="saleInformation.jsp"  role="button" aria-haspopup="true" aria-expanded="false">Ventas </a></li>
                        </ul>                        
                    </div>
                </div>
            </nav>
        </div>
    </body>
</html>
