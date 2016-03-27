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

        <title>JSP Page</title>
    </head>
    <body>
        <form class="inline-form" method="POST" action="SaleServlet">
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="nrodocument">Identification:</label>
                        <input type="number" name="nrodocument" class="form-control" required="true"  placeholder="Identificacion">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="name">Plate vehicle:</label>
                        <input type="text" name="plate" class="form-control" required="true" placeholder="Matricula vehiculo" >
                    </div>
                </div>
                <div class="col-md-4">
                    <div class=" form-inline">
                        <label for="year">Sale date:</label>
                        <br>
                        <div>                    
                            <input  type="number" name="year" class="form-control" placeholder="Año">                    
                            <input  type="number" name="month" class="form-control" placeholder="Mes">                 
                            <input  type="number" name="day" class="form-control" placeholder="Dia">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="nrodocument">Installments:</label>
                        <input type="number" name="installments" class="form-control" required="true"  placeholder="Cuotas">
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <label for="name">Installments amount:</label>
                        <input type="text" name="installmentAmount" class="form-control" required="true" placeholder="Valor por cuota" >
                    </div>
                </div>  
            </div>
            <div class="row">
                <div class="col-md-8">
                    <input type="submit" name="action" value="Add" id="addID" class="btn btn-md btn-success"/>
                    <input type="submit" name="action" value="Delete" class="btn btn-md btn-success"/>          
                </div>
            </div>
        </form>

        <br>
        <form action="./SaleServlet" method="POST">
            <table class="table table-hover">
                <input type="submit" name="action" value="SearchAll" class="btn btn-md btn-success">
                <thead style="font-size:150%;">
                    <tr>
                        <th>ID</th>
                        <th>Client</th>
                        <th>Vehicle</th>
                        <th>Date</th>
                        <th>Installments</th>
                        <th>installment amount</th>
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
        </form>
    </body>
</html>
