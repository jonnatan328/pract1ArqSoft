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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        
        <link href="./bootstrap.css" rel="stylesheet" media="screen">
        <link href="<?php echo base_url()?>/css/style.css" rel="stylesheet">
        <link  rel= "stylesheet"  href= "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >
        <link  rel= "stylesheet"  href= "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" >
        <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" ></script>
        <script type="text/javascript" src="./jquery-2.0.2.min.js"></script>
        <script src="./bootstrap.js"></script>
        <title>Pagina principal</title>
    </head>
    <body>
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
                        <img src="http://placehold.it/1200x200?text=IMAGE" alt="Image">
                        <div class="carousel-caption">
                          <h3>Sell $</h3>
                          <p>Money Money.</p>
                        </div>      
                      </div>

                      <div class="item">
                        <img src="http://placehold.it/1200x200?text=Another Image Maybe" alt="Image">
                        <div class="carousel-caption">
                          <h3>More Sell $</h3>
                          <p>Lorem ipsum...</p>
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
                                    <li class="active"><a href="./ClientServlet"  role="button" aria-haspopup="true" aria-expanded="false">Clientes </a></li>
                                    <li><a href="./VehicleServlet"  role="button" aria-haspopup="true" aria-expanded="false">Vehiculos </a></li>
                                    <li><a href="#"  role="button" aria-haspopup="true" aria-expanded="false">Ventas </a></li>
                                
                            </ul>
                                                      
                        </div>
                    </div>
                </nav>
            </div>
    </body>
</html>
