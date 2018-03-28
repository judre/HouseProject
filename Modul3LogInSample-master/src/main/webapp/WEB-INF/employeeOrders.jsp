<%-- 
    Document   : employeeOrders
    Created on : 28-03-2018, 16:19:37
    Author     : andre
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="DBAccess.Connector"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<form name="Login" action="FrontController" method="POST">
        <input type="hidden" name="command" value="Login">
        <input type="Submit" value="Go to employeepage">
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>OrderId</b></td>
<td><b>Quantity</b></td>
<td><b>Type of block</b></td>
<td><b>UserID</b></td>

</tr>
<%
try{ 
    
Connection con = Connector.connection();
Statement statement = con.createStatement();

String sql = "SELECT * FROM odetails";


ResultSet resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="#DEB887">

<td><%=resultSet.getInt("Order_orderId") %></td>
<td><%=resultSet.getInt("quantity") %></td>
<td><%=resultSet.getString("legoBlockName") %></td>
<td><%=resultSet.getInt("User_userId") %></td>


</tr>

<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>


</table>