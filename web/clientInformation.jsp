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
            <br>
            <form action="./ClientServlet" method="POST" role="form">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="nrodocument">Identificacion:</label>
                            <input type="number" name="nrodocument" class="form-control" placeholder="Identificacion" value="${client.nrodocument}">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="name">Nombres:</label>
                            <input type="text" name="name" class="form-control"  placeholder="Nombres" value="${client.name}" >
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="lastname">Apellidos:</label>
                            <input type="text" name="lastname" class="form-control" placeholder="Apellidos" value="${client.lastname}" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="phone">Direccion:</label>
                            <input type="text" name="address" class="form-control" placeholder="Direccion" value="${client.phone}" >
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="address">Telefono:</label>
                            <input type="text" name="phone" class="form-control" placeholder="Telefono" value="${client.address}" >
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="adress">Celular:</label>
                            <input type="text" name="cellphone" class="form-control" placeholder="Celular" value="${client.cellphone}" >
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="phone">Fecha de nacimiento:</label>
                            <br/>
                            <input style="display: inline-block; width:32%" type="number" name="year" class="form-control" 
                                   placeholder="Año" value="" min="0" max="9999" >
                            <input style="display: inline-block; width:32%" type="number" name="month" class="form-control" 
                                   placeholder="Mes" value="" min="1" max="12" >
                            <input style="display: inline-block; width:32%" type="number" name="day" class="form-control" 
                                   placeholder="Dia" value="" min="1" max="31" >

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-8">
                            <input type="submit" name="action" value="Registrar" class="btn btn-md btn-success"/>
                            <input type="submit" name="action" value="Editar" class="btn btn-md btn-success"/>
                            <input type="submit" name="action" value="Borrar" class="btn btn-md btn-success"/>
                            <input type="submit" name="action" value="Buscar" class="btn btn-md btn-success"/> 
                            <input type="submit" name="action" value="Mostrar todos" class="btn btn-md btn-success"/>   
                        </div>
                    </div>
                    <div class="row">
                        <h3 style="color: #d9534f">${ERROR}</h3>
                        <h3 style="color: #5cb85c">${SUCCESS}</h3>
                    </div>
                    </br>
                    <div class="row">
                        <div class="col-md-12">
                            <c:choose>
                                <c:when test="${searchall == true}">
                                    <table class="table table-hover">
                                        <thead style="font-size:150%;">
                                            <tr>
                                                <th>Documento</th>
                                                <th>Nombres</th>
                                                <th>Apellidos</th>
                                                <th>Direccion</th>
                                                <th>Telefono</th>
                                                <th>Celular</th>
                                                <th>Fecha de nacimiento</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${allClients}" var="clien">            
                                                <tr>
                                                    <td>${clien.nrodocument}</td>
                                                    <td>${clien.name}</td>
                                                    <td>${clien.lastname}</td>
                                                    <td>${clien.address}</td>
                                                    <td>${clien.phone}</td>
                                                    <td>${clien.cellphone}</td>
                                                    <td>${clien.birthDate}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody> 
                                    </table>
                                </c:when>
                                <c:when test="${searchall == false}">
                                    <table class="table table-hover">
                                        <thead style="font-size:150%;">
                                            <tr>
                                                <th>Documento</th>
                                                <th>Nombres</th>
                                                <th>Apellidos</th>
                                                <th>Direccion</th>
                                                <th>Telefono</th>
                                                <th>Celular</th>
                                                <th>Fecha de nacimiento</th>
                                            </tr>
                                        </thead>
                                        <tbody>                                                  
                                            <tr>
                                                <td>${client.nrodocument}</td>
                                                <td>${client.name}</td>
                                                <td>${client.lastname}</td>
                                                <td>${client.address}</td>
                                                <td>${client.phone}</td>
                                                <td>${client.cellphone}</td>
                                                <td>${client.birthDate}</td>
                                            </tr>

                                        </tbody> 
                                    </table>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>
            </form>
        </div>
    </body>
</html>
