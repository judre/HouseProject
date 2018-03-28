<%-- 
    Document   : Order
    Created on : 24-03-2018, 19:40:16
    Author     : andre
--%>

<%@page import="FunctionLayer.Wall"%>
<%@page import="FunctionLayer.House"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% House legohouse = new House(); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <title>Cupcake Shop</title>
</head>
<body>
    <form name="toCustomerPage" action="FrontController" method="POST">
        <input type="hidden" name="command" value="toCustomerPage">
        <input type="Submit" value="Go to customerpage">
    <form id="addProduct" action="FrontController" method="POST">
        <input type="hidden" name="command" value="Order">
        <table class="table table-striped">
            <tr>
                <th> Order Id  |</th>
                <th> User Id  | </th>
                <th> Quantity | </th>
                <th> Legoblock Name |</th>
            </tr>
            <% House orderline = (House) session.getAttribute("legohouse");
                if (legohouse.getWalls() != null) {
                    for (int i = 0; i < orderline.getWalls().size(); i++) {
                        out.print("<tr><td>" + orderline.getOrderId() + "</td>" + "<td>" + orderline.getUserId() + "</td>" + "<td>" + orderline.getWalls().get(i).getBlockAmount() + "</td>" + "<td>" + orderline.getWalls().get(i).getBlock().getName() + "</td>" + "</tr>");
                    }
                }
            %>
            </tbody>
        </table>
    </form>
<body>
</body>
</html>