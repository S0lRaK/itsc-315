<%-- 
    Document   : login
    Created on : 10-Nov-2017, 1:28:11 PM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>NotesKeepr Login</h1>
        
        <form action="login" method="post">
            username: <input type="text" name="username"><br>
            password: <input type="password" name="password"><br>
            
            <input type="submit" value="Login">
        </form>    
        
        ${message}
        
    </body>
</html>
