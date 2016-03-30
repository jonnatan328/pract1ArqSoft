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

        <title>Información de venta</title>
    </head>
    <body>
        <div class="container">
            <form class="inline-form" method="POST" action="SaleServlet">
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="nrodocument">Identificacion:</label>
                            <input type="number" name="nrodocument" class="form-control"  placeholder="Identificacion">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="name">Matricula:</label>
                            <input type="text" name="plate" class="form-control"  placeholder="Matricula vehiculo" >
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class=" form-inline" >
                            <label for="year">Fecha de venta:</label>
                            <br>
                            <div>                    
                                <input style="width: 80px"  type="number" name="year" class="form-control" placeholder="Año">                    
                                <input style="width: 80px"  type="number" name="month" class="form-control" placeholder="Mes">                 
                                <input style="width: 80px"  type="number" name="day" class="form-control" placeholder="Dia">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="nrodocument">Cuotas:</label>
                            <input type="number" name="installments" class="form-control" placeholder="Cantidad de cuotas">
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-group">
                            <label for="name">Valor por cuota:</label>
                            <input type="number" name="installmentAmount" class="form-control" placeholder="Valor por cuota" >
                        </div>
                    </div>  
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <input type="submit" name="action" value="Registrar" id="addID" class="btn btn-md btn-success"/>                        
                        <input type="submit" name="action" value="Mostrar todos" class="btn btn-md btn-success">
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col-md-8">
                    <p style="color: #d9534f">${ERROR}</p>
                    <p style="color: #5cb85c">${SUCCESS}</p>  
                </div>
            </div>
            <br>     
            <table class="table table-hover">                
                <thead style="font-size:150%;">
                    <tr>
                        <th>ID</th>
                        <th>Cliente</th>
                        <th>Vehiculo</th>
                        <th>Fecha de venta</th>
                        <th>Cuotas</th>
                        <th>Valor/cuota</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${allsales}" var="sales">            
                        <tr>
                            <td>${sales.id}</td>
                            <td>${sales.client.nrodocument}</td>
                            <td>${sales.vehicle.plate}</td>
                            <td>${sales.date}</td>
                            <td>${sales.installments}</td>
                            <td>${sales.installment_amount}</td>
                        </tr>
                    </c:forEach>
                </tbody> 
            </table>

        </div>
    </body>
</html>
