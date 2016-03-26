<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./index.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Información del cliente</title>

        <link  rel= "stylesheet"  href= "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" >
        <link  rel= "stylesheet"  href= "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" >
        <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" ></script>
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
                        <div class="row">  
                            <input type="submit" name="action" value="Add" class="btn btn-lg btn-success"/>
                            <input type="submit" name="action" value="Edit" class="btn btn-lg btn-success"/>
                            <input type="submit" name="action" value="Delete" class="btn btn-lg btn-success"/>
                            <!--<input type="submit" name="action" value="Search" class="btn btn-lg btn-success"/>-->
                            <a href="#modal_busqueda" role="button" class="btn btn-success btn-lg" data-toggle="modal">Search</a>
                            <input type="submit" name="action" value="SearchAll" class="btn btn-lg btn-success"/>
                        </div> 
                   </div>
                </div>
            </form>       
             <div id="modal_busqueda" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                                <h1>Ingrese el documento</h1>
                        </div>
                        <div class="modal-body">
                            <label for="nrodocument">Número documento:</label>
                            <input type="number" name="documentSearch" class="form-control"  placeholder="identificacion" >
                        </div>
                        <div class="modal-footer">
                                <!--<button type="button" name="action" class="btn btn-primary" formaction="./ClientServlet" aria-label="Left Align" >Search </button>-->
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
    </body>
</html>
