<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.mysql.cj.api.mysqla.result.Resultset"%>
<%@page import="DBAccess.Connector"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>


<form name="Login" action="FrontController" method="POST">
        <input type="hidden" name="command" value="Login">
        <input type="Submit" value="Go to customerpage">
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>Order ID</b></td>
<td><b>Quantity</b></td>
<td><b>Block Size</b></td>

</tr>
<%
try{ 
    List<Order> userOrders = (List<Order>) request.getAttribute("userOrders");
for (Order order : userOrders) {

%>
<tr bgcolor="#DEB887">

<td><%=order.getOrder_orderId() %></td>
<td><%=order.getQuantity() %></td>
<td><%=order.getLegoBlockName() %></td>



</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>