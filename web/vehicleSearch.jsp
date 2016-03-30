<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./index.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/style.css"  > 
        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <title>Busqueda vehiculos</title>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <form action="VehicleServlet" method="POST" class="form-inline">
                        <div class="form-group">
                            <label for="plateid">Matricula:</label>
                            <input type="text" class="form-control" name="plate" id="plateid" placeholder="Matricula del vehiculo" class="">
                            <input type="submit" class="btn btn-default btn-success" name="action" value="Buscar">
                            <input type="submit" class="btn btn-default btn-success" name="action" value="Mostrar todos">
                        </div>
                    </form>
                </div>
            </div>

            <br>

            <c:choose>
                <c:when test="${searchAll == false}">
                    <div class="row">
                        <table class="table table-bordered">
                            <th>Matricula</th>
                            <th>Marca</th>
                            <th>Modelo</th>
                            <tr>
                                <td>${vehicle.plate}</td>
                                <td>${vehicle.brand}</td>
                                <td>${vehicle.model}</td>
                            </tr>
                            <th>Año</th>
                            <th>Color</th>
                            <th>Combustible</th>
                            <tr>
                                <td>${vehicle.year}</td>
                                <td>${vehicle.color}</td>
                                <td>${vehicle.fuel}</td>
                            </tr>
                            <th>Transmision</th>
                            <th>Puertas</th>
                            <th>Precio</th>                      
                            <tr>
                                <td>${vehicle.transmission}</td>
                                <td>${vehicle.doors}</td>
                                <td>${vehicle.price}</td>
                            </tr>
                        </table>
                    </div>
                </c:when>
                <c:when test="${searchAll == true}">
                    <table class="table table-bordered">
                        <th>Placa</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Año</th>
                        <th>Precio</th>

                        <c:forEach items="${allVehicles}" var="vehic">
                            <tr>
                                <td>${vehic.plate}</td>
                                <td>${vehic.brand}</td>
                                <td>${vehic.model}</td>
                                <td>${vehic.year}</td>
                                <td>${vehic.price}</td>
                            </tr>
                        </c:forEach> 
                    </table>
                </c:when>
            </c:choose>
            <h3 style="color: #d9534f">${ERROR}</h3>
            <h3 style="color: #5cb85c">${SUCCESS}</h3>
            <div >
                <img style="width: 70% ;margin: 0 auto" src="${img}" alt="" class="img-responsive img-rounded">
            </div>      
        </div>
        <br>
        <br>
    </body>
</html>
