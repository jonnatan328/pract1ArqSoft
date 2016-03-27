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
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/style.css"  > 
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>

        <title>Información del vehiculo</title>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#brand").each(function () {
                    this.selected = (this.value == valor);
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <form action="./VehicleServlet" method="POST" role="form" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="plate">Plate:</label>
                            <input type="text" name="plate" class="form-control"  placeholder="Placa" value="${vehicle.plate}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="brand">Brand:</label>
                            <select name="brand" id="brand" class="form-control">
                                <option value="Chevrolet" selected>Chevrolet</option>
                                <option value="Renault" >Renault</option>
                                <option value="Mazda" >Mazda</option>
                                <option value="Toyota" >Toyota</option>
                                <option value="BMW" >BMW</option>
                                <option value="Audi" >Audi</option>  
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="model">Model:</label>
                            <input type="text" name="model" class="form-control" placeholder="Modelo" value="${vehicle.model}" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="plate">Year:</label>
                            <input type="text" name="year" class="form-control"  placeholder="Año" value="${vehicle.year}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="brand">Color:</label>
                            <input type="text" name="color" class="form-control"  placeholder="Color" value="${vehicle.color}">

                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="model">Fuel:</label>
                            <input type="text" name="fuel" class="form-control" placeholder="Combustible" value="${vehicle.fuel}" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="plate">Transmission:</label>
                            <input type="text" name="transmission" class="form-control"  placeholder="Transmision" value="${vehicle.transmission}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="brand">Doors:</label>
                            <input type="text" name="doors" class="form-control"  placeholder="Puertas" value="${vehicle.doors}">

                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="model">Price</label>
                            <input type="text" name="price" class="form-control" placeholder="Precio" value="${vehicle.price}" >
                        </div>
                    </div>
                </div>
                <div class="row">    
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="image">Image:</label>
                            <input type="file" name="image" class="" value="Seleccione un archivo" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5">
                        <input type="submit" name="action" value="Add" class="btn btn-md btn-success"/>
                        <input type="submit" name="action" value="Edit" class="btn btn-md btn-success"/>
                        <input type="submit" name="action" value="Delete" class="btn btn-md btn-success"/>
                        <!--<input type="submit" name="action" value="Search" class="btn btn-md btn-success"/>-->
                        <a href="#modal" type="button" role="button" class="btn btn-md btn-succes" data-toggle="modal">Search</a>
                        <input type="submit" name="action" value="SearchAll" class="btn btn-md btn-success"/>
                    </div>
                </div>     


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
            </form>
            <div id="modal" class="modal fade" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1>Ingresar Placa del vehiculo</h1>
                        </div>
                        <form action="./VehicleServlet" method="POST" role="form">
                            <div class="modal-body">
                                <div class="form-group">

                                    <label for="document">Placa:</label>
                                    <input type="text" name="platesearch" class="form-control" required="true"  placeholder="Placa" >

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
