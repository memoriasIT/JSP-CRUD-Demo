<%-- 
    Document   : orders
    Created on : 09-may-2021, 11:48:23
    Author     : memoriasIT
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entity.PurchaseOrder"%>
<%@page import="entity.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Orders</title>
        <jsp:include page="includes.jsp"></jsp:include>
        <%
            List<PurchaseOrder> orders = (List<PurchaseOrder>) request.getAttribute("orders");
            Customer cliente = (Customer) request.getAttribute("cliente");
        %>
    </head>
    <body class="container">
        <h1 style="margin-top: 1em;">Lista de pedidos del cliente: <%= cliente.getCustomerId() %></h1>
        <h3><a href="ServletNewOrder?id=<%= cliente.getCustomerId() %>">New Order</a></h3>
        
            <table class="u-full-width">
            <thead>
              <tr>
                <th>Order Number</th>
                <th>ProductID</th>
                <th>Quantity</th>
                <th>Date of Sale</th>
                
              </tr>
            </thead>
            <tbody>
                <%
                    for( PurchaseOrder order : orders){ 
                %>    
                <tr>
                    <td><%= order.getOrderNum() %></td>
                    <td><%= order.getProductId().getProductId() %></td>
                    <td><%= order.getQuantity() %></td>
                    <td><%= new SimpleDateFormat("dd/MM/YYY").format(order.getSalesDate()) %></td>
                  </tr>
                <%
                    }
                %>   
    </body>
</html>
