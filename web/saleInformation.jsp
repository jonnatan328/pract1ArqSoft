<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="./index.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="./SaleServlet" method="POST" role="form">
            <label for="clientID">ID cliente:</label>
            <input type="text" name="clientID" required="true">
            <br>
            <label for="vehiclePlate">Plate vehicle:</label>
            <input type="text" name="vehiclePlate" required="true">
            <br>
            <label for="currentDate">Fecha de venta:</label>
            <input type="date" name="currentDate" required="true">
            <br>
            <input type="submit" name="action" value="Guardar">            
        </form>
        <br>
        <br>
        
        <p>${client}</p>
       <p>Client ID: ${client.nrodocument}</p>
        <p>Client name: ${client.name}</p>
        <p>Client lastname: ${client.lastname}</p>
        <p>Client address: ${client.address}</p>
        <p>Client phone: ${client.phone}</p>
        <p>Client cellphone: ${client.cellphone}</p>
        
        <br>
        <br>
        <p>Vehicle plate: ${vehicle.plate}</p>
        <p>Vehicle brand: ${vehicle.brand}</p>
        <p>Vehicle model: ${vehicle.model}</p>
        <p>Vehicle year: ${vehicle.year}</p>
        <p>Vehicle image: ${vehicle.image}</p>
        
    </body>
</html>
