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
                            <label for="plate">Matricula:</label>
                            <input type="text" name="plate" class="form-control"  placeholder="Matricula del vehiculo" required="true" value="${vehicle.plate}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="brand">Marca:</label>
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
                            <label for="model">Modelo:</label>
                            <input type="text" name="model" class="form-control" placeholder="Modelo" value="${vehicle.model}" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="plate">Año:</label>
                            <input type="number" name="year" class="form-control"  placeholder="Año de fabricación" value="${vehicle.year}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="brand">Color:</label>
                            <input type="text" name="color" class="form-control"  placeholder="Color del vehiculo" value="${vehicle.color}">

                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="model">Combustible:</label>
                            <input type="text" name="fuel" class="form-control" placeholder="Tipo de combustible" value="${vehicle.fuel}" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="plate">Transmision:</label>
                            <input type="text" name="transmission" class="form-control"  placeholder="Tipo de transmision" value="${vehicle.transmission}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="brand">Puertas:</label>
                            <input type="number" name="doors" class="form-control"  placeholder="Cantidad de puertas" value="${vehicle.doors}">

                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="model">Precio:</label>
                            <input type="number" name="price" class="form-control" placeholder="Precio del vehiculo" value="${vehicle.price}" >
                        </div>
                    </div>
                </div>
                <div class="row">    
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="image">Foto vehiculo:</label>
                            <input type="file" name="image" class="" value="Seleccione un archivo" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5">
                        <input type="submit" name="action" value="Registrar" class="btn btn-md btn-success"/>
                        <input type="submit" name="action" value="Editar" class="btn btn-md btn-success"/>
                        <input type="submit" name="action" value="Borrar" class="btn btn-md btn-success"/>
                    </div>
                </div>                 
                <h3 style="color: #d9534f">${ERROR}</h3>
                <h3 style="color: #5cb85c">${SUCCESS}</h3>
            </form>
        </div>
    </body>
</html>
