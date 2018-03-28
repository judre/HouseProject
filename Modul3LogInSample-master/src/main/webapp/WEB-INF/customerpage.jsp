<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../WEB-INF/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Customer home page</title>
    </head>
    <body> 
        <form name="toOrder" action="FrontController" method="POST">
        <input type="hidden" name="command" value="toOrder">
        <input type="Submit" value="HouseCalculator">
        </form>
        <form name="toUserOrders" action="FrontController" method="POST">
            <input type="hidden" name="command" value="toUserOrders">
            <input type="submit" value="Your orders">
        </form>
        <h1>Hello <%=request.getParameter( "email" )%> </h1>
        You have now logged into our site.
        
        You can order elements for your house at housecalculator, and see all your orders in 
        
    </body>
</html>
