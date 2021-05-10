<%-- 
    Document   : listaCustomers
    Created on : 08-may-2021, 20:58:17
    Author     : memoriasIT
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes.jsp"></jsp:include> 
        <title>Lista de clientes</title>
        
        <%
            List<Customer> listaClientes = (List<Customer>) request.getAttribute("listaClientes");
        %>
        
    </head>
    <body>
        <div class="container">
            <h1 style="margin-top: 1em;">Lista de clientes</h1>
            
            <form action="ServletCustomerListar" method="post">
                <div class="row">
                  <div class="six columns">
                    <input class="u-full-width" name="filtro" type="text" value="filtro" placeholder="Búsqueda" id="filtro">
                  </div>
                  <div class="six columns">
                    <input class="button-primary" type="submit" value="Filtrar">
                  </div>
                
              </form>
            
            <table class="u-full-width">
            <thead>
              <tr>
                <th>Name</th>
                <th>Phone</th>
                <th>Email</th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
                <%
                    for( Customer cliente : listaClientes){ 
                %>    
                <tr>
                    <td><%= cliente.getName() %></td>
                    <td><%= cliente.getPhone() %></td>
                    <td><%= cliente.getEmail() %></td>
                    <td><a href="ServletEditar?id=<%= cliente.getCustomerId() %>">Editar</a></td>
                    <td><a href="ServletBorrar?id=<%= cliente.getCustomerId() %>">Borrar</a></td>
                    
                  </tr>
                <%
                    }
                %>   
              
            </tbody>
          </table>
        
        </div>
    </body>
</html>
