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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="http://code.jquery.com/jquery-2.2.2.min.js"></script>
        
        <title>Información del cliente</title>
                
        <style type="text/css">
            tbody, thead tr { display: block; }

            tbody {
                height: 350px;
                overflow-y: scroll;
                overflow-x: hidden;
            }

            tbody td,thead th {
                width: 400px;
            }

            thead th:last-child{
                width: 416px; /* 400px + 16px scrollbar width */
            }
        </style>
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
                     <input type="number" name="nrodocument" class="form-control" required="true"  placeholder="Identificacion" value="${client.nrodocument}">
                   </div>
                </div>
                <div class="col-md-4">
                   <div class="form-group">
                     <label for="name">First Name:</label>
                     <input type="text" name="name" class="form-control"  placeholder="Nombre" value="${client.name}" >
                   </div>
                </div>
                <div class="col-md-4">
                   <div class="form-group">
                     <label for="lastname">Last Name:</label>
                     <input type="text" name="lastname" class="form-control" placeholder="Apellido" value="${client.lastname}" >
                   </div>
                </div>
               </div>
               <div class="row">
                 <div class="col-md-4">
                   <div class="form-group">
                     <label for="phone">Phone:</label>
                     <input type="number" name="phone" class="form-control" placeholder="Telefono" value="${client.phone}" >
                   </div>
                 </div>
                 <div class="col-md-4">
                   <div class="form-group">
                     <label for="address">Address:</label>
                     <input type="text" name="address" class="form-control" placeholder="Direccion" value="${client.address}" >
                   </div>
                 </div>
                 <div class="col-md-4">
                   <div class="form-group">
                     <label for="adress">Cellphone:</label>
                     <input type="number" name="cellphone" class="form-control" placeholder="Celular" value="${client.cellphone}" >
                   </div>
                 </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <input type="submit" name="action" value="Add" class="btn btn-md btn-success"/>
                        <input type="submit" name="action" value="Edit" class="btn btn-md btn-success"/>
                        <input type="submit" name="action" value="Delete" class="btn btn-md btn-success"/>
                        <a href="#modal" type="button" role="button" class="btn btn-md btn-succes" data-toggle="modal">Search</a>
                        <input type="submit" name="action" value="SearchAll" class="btn btn-md btn-success"/>   
                    </div>
                </div></br>
                <div class="row">  
                   <div class="col-md-12">
                       
                       <table class="table table-hover">
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
                           <tbody>
                            <c:forEach items="${allClients}" var="clien">            
                                    <tr>
                                        <td>${clien.nrodocument}</td>
                                        <td>${clien.name}</td>
                                        <td>${clien.lastname}</td>
                                        <td>${clien.phone}</td>
                                        <td>${clien.address}</td>
                                        <td>${clien.cellphone}</td>
                                    </tr>
                            </c:forEach>
                           </tbody> 
                        </table>
                       
                    </div>
                </div>
            </form>
             <div id="modal" class="modal fade" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                                <h1>Ingresar número de documento</h1>
                        </div>
                        <form action="./ClientServlet" method="POST" role="form">
                            <div class="modal-body">
                                <div class="form-group">

                                        <label for="document">Número documento:</label>
                                        <input type="number" name="document" class="form-control" required="true"  placeholder="identificacion" >

                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" name="action"  class="btn btn-md btn-success">Search</button>
                                <button type="button" class="btn btn-md btn-succes" data-dismiss="modal">Cloce</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
           
        </div>
    </body>
</html>
