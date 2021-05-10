<%-- 
    Document   : createOrder
    Created on : 09-may-2021, 13:50:53
    Author     : memoriasIT
--%>

<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes.jsp"></jsp:include>
        <title>Create Order</title>
        <%
          Customer cliente = (Customer) request.getAttribute("cliente");  
        %>    
    </head>
    <body class="container" style="margin: 50px auto">
        <form  action="ServletNewOrder" method="post">
        <div class="row">
          <div class="six columns">
            <label for="orderNum">OrderNum</label>
            <input class="u-full-width" type="number" name="orderNum" placeholder="" id="orderNum">
          </div>
          <div class="six columns">
            <label for="clientNum">clientNum</label>
            <input class="u-full-width" type="number" name="clientNum" placeholder="" id="clientNum" value="<%= cliente.getCustomerId() %>">
          </div>
        </div>
          <div class="row">
          <div class="six columns">
            <label for="prodID">ProductID</label>
            <input class="u-full-width" name="prodID" type="number" placeholder="" id="prodID">
          </div>
          <div class="six columns">
            <label for="quantity">Quantity</label>
            <input class="u-full-width" name="quantity" type="number" placeholder="" id="quantity" value="">
          </div>
          <div class="six columns">
            <label for="date">Date</label>
            <input class="u-full-width" name="quantity" type="text" placeholder="Date format dd/MM/YYYY" id="date" value="">
          </div>
        </div>
        <input class="button-primary" type="submit" value="Submit">
      </form>
    </body>
</html>
