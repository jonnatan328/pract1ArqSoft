<%-- 
    Document   : clientInformation
    Created on : 21/03/2016, 04:24:08 PM
    Author     : acerpc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./index.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>Información del cliente</title>
       
        <!--<link  rel= "stylesheet"  href= "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" >-->
        <!--<link href = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"   rel="stylesheet"></link>-->
        <!--<link href="/css/result-light.css" type="text/css" rel="stylesheet"></link>-->
        <script src="http://code.jquery.com/jquery-2.2.2.min.js"></script>
        <!--<script src="./jquery-2.0.2.min.js"></script>-->
        <script>
             
                 $(document).ready(function(){
                    e.preventDefault();
                    $("#openModal").click(function(){
                       $("#modal").modal('show');
                    });
                  });
                 //alert('algo');
                 //window.opener.document.getElementById('search').value='Numero doc';
                 //$('#modal').modal('show');
                 //document.getElementById("modal").showModal();
             
        </script>
    </head>
    <body>
        <div class="container">
            <div class="formulario-registro-cabecera" align="center" style="background-color:lightgrey; font-size:200%; ">
                <!--<h1>Informacion del cliente</h1>-->
            </div>
           <h1><p> ${message} ${message1} ${message2} ${message3} ${message4} ${message5}</p></h1>
           <form action="./ClientServlet" method="POST" role="form">
               <div class="row">
                <div class="col-md-4">
                   <div class="form-group">
                     <label for="nrodocument">Número documento:</label>
                     <input type="number" name="nrodocument" class="form-control" required="true"  placeholder="identificacion" value="${client.nrodocument}">
                   </div>
                   <div class="form-group">
                     <label for="name">First Name:</label>
                     <input type="text" name="name" class="form-control"  placeholder="Nombre" value="${client.name}" >
                   </div>
                   <div class="form-group">
                     <label for="lastname">Last Name:</label>
                     <input type="text" name="lastname" class="form-control" placeholder="Apellido" value="${client.lastname}" >
                   </div>
                   <div class="form-group">
                     <label for="phone">Phone:</label>
                     <input type="number" name="phone" class="form-control" placeholder="Telefono" value="${client.phone}" >
                   </div>
                   <div class="form-group">
                     <label for="address">Address:</label>
                     <input type="text" name="address" class="form-control" placeholder="Direccion" value="${client.address}" >
                   </div>
                   <div class="form-group">
                     <label for="adress">Cellphone:</label>
                     <input type="number" name="cellphone" class="form-control" placeholder="Celular" value="${client.cellphone}" >
                   </div>
                 </div>
                   <div class="col-md-8">
                       <div class="row">
                       <table class="table table-bordered">
                           <thead style="font-size:150%;">
                               <tr>
                                    <th>Document</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th>Cellphone</th>
                                </tr>
                           </thead>
                            <c:forEach items="${allClients}" var="clien">
                                <tbody>
                                    <tr>
                                        <td>${clien.nrodocument}</td>
                                        <td>${clien.name}</td>
                                        <td>${clien.lastname}</td>
                                        <td>${clien.phone}</td>
                                        <td>${clien.address}</td>
                                        <td>${clien.cellphone}</td>
                                    </tr>
                                </tbody>
                            </c:forEach> 
                        </table>
                       </div>
                       <div id="search" style="display: none">
                           <div class="form-group">
                                <label for="nrodocument2">Número documento:</label>
                                <input type="number" name="nrodocument2" class="form-control" required="true"  placeholder="identificacion" value="${client.nrodocument}">
                            </div>
                       </div>
                        <div class="row">  
                            <input type="submit" name="action" value="Add" class="btn btn-lg btn-success"/>
                            <input type="submit" name="action" value="Edit" class="btn btn-lg btn-success"/>
                            <input type="submit" name="action" value="Delete" class="btn btn-lg btn-success"/>
                            <input type="submit" name="action" value="Search" class="btn btn-lg btn-success"/>
                           
                            <input type="submit" name="action" value="SearchAll" class="btn btn-lg btn-success"/>
                        </div> 
                   </div>
                </div>
            </form>   
             <a href="#" id="openModal" onclick="abrirModal();" role="button" class="btn btn-success btn-lg" >Search modal</a>         
             <a href="#modal" role="button" class="btn btn-large btn-primary" data-toggle="modal"><i class="glyphicon glyphicon-search"></i></a> 
             <div id="modal" class="modal fade" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                                <h1>Ingresar número de documento</h1>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label for="nrodocument2">Número documento:</label>
                                <input type="number" name="nrodocument2" class="form-control" required="true"  placeholder="identificacion" >
                            </div>
                        </div>
                        <div class="modal-footer">
                                <!--<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>-->
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
