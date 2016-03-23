<%-- 
    Document   : vehicleInformation
    Created on : 22/03/2016, 08:59:51 AM
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Información del vehiculo</title>
    </head>
    <body>
        <div class="container">
          
            <div class="formulario-registro-cabecera" align="center" style="background-color:lightgrey; font-size:200%; ">
                <h1>Informacion del Vehiculo</h1>
            </div>
           <h1><p>Mensaje: ${message} ${message1} ${message2} ${message3} </p></h1>
           <form action="./VehicleServlet" method="POST" role="form">
               <div class="row">
               <div class="col-md-5">
                  <div class="form-group">
                    <label for="plate">Plate:</label>
                    <input type="text" name="plate" class="form-control"  placeholder="Placa" value="${vehicle.plate}">
                  </div>
                  <div class="form-group">
                    <label for="brand">Brand:</label>
                    <input type="text" name="brand" class="form-control" placeholder="Marca" value="${vehicle.brand}" >
                  </div>
                  <div class="form-group">
                    <label for="model">Model:</label>
                    <input type="text" name="model" class="form-control" placeholder="Modelo" value="${vehicle.model}" >
                  </div>
                  <div class="form-group">
                    <label for="year">Year:</label>
                    <input type="number" name="year" class="form-control" placeholder="Año" value="${vehicle.year}" >
                  </div>
                  <div class="form-group">
                    <label for="image">Image:</label>
                    <input type="file" name="image" class="form-control" value="Seleccione un archivo" >
                  </div>
                  
                </div>
                </div>
                  <div class="row">
                      <div class="col-md-5">
                             <input type="submit" name="action" value="Add" class="btn btn-lg btn-success"/>
                             <input type="submit" name="action" value="Edit" class="btn btn-lg btn-success"/>
                             <input type="submit" name="action" value="Delete" class="btn btn-lg btn-success"/>
                             <input type="submit" name="action" value="Search" class="btn btn-lg btn-success"/>
                             <input type="submit" name="action" value="SearchAll" class="btn btn-lg btn-success"/>
                      </div>
                  </div>     
            </form>
               
                    <br>
                    <table class="table table-bordered">
                        <th>Placa</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Año</th>
              
                        <c:forEach items="${allVehicles}" var="vehi">
                            <tr>
                                <td>${vehi.plate}</td>
                                <td>${vehi.brand}</td>
                                <td>${vehi.model}</td>
                                <td>${vehi.year}</td>
                            </tr>
                        </c:forEach> 
                    </table>
        </div>
    </body>
</html>
