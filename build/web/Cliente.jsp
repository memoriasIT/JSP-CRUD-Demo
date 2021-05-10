<%-- 
    Document   : Cliente
    Created on : 08-may-2021, 22:35:42
    Author     : memoriasIT
--%>

<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes.jsp"></jsp:include>
        <%
            Customer cliente = (Customer) request.getAttribute("cliente");
            String strName = "", strEmail = "", strPhone = "", strId= "";
            if (cliente != null) {
                strId = String.valueOf(cliente.getCustomerId());
                strName = cliente.getName();
                strEmail = cliente.getEmail();
                strPhone = cliente.getPhone();
            }
        %>
        <title>Cliente</title>
    </head>
    <body>
        <div class="container" style ="margin: 0 auto; margin-top:20%;">
            <% if (cliente != null) {%>
                <a href="ServletOrders?id=<%= strId %>">See orders</a>  
            <% }%>
        
             
            
        <form action="ServletGuardar">
            <input type="hidden" name="id" value="<%= strId %>" />
            <label for="fname">Name:</label><br>
            <input type="text" id="fname" name="fname" value="<%= strName %>"><br>
            <label for="email">Last name:</label><br>
            <input type="text" id="email" name="email" value="<%= strEmail %>"><br><br>
            <label for="phone">Phone:</label><br>
            <input type="text" id="phone" name="phone" value="<%= strPhone %>"><br><br>
            <input type="submit" value="Submit">
          </form> 
        </div>
        
    </body>
</html>
