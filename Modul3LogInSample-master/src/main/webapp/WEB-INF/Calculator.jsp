<%-- 
    Document   : Calculator
    Created on : 24-03-2018, 19:42:57
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        <h1>House Calculator</h1>
        
        <form name="Calculator" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="Calculator">
                        Length:
                        <br>
                        <input type="text" name="length" Placeholder="1">
                        <br>
                        Width:
                        <br>
                        <input  id="legohousewidth" type="text" name="width" Placeholder="minimum 4" >
                        <br>
                        Height:
                        <br>
                        <input type="text" name="height" Placeholder="1">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
    </body>
</html>
