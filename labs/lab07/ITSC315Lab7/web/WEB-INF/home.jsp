<%-- 
    Document   : home
    Created on : 10-Nov-2015, 9:01:12 AM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home</h1>
        <h3>Hi ${currentUser.firstName}</h3>
        <p>
            <a href="users">Manage Users</a> | <a href="home?action=logout">Logout</a>  <br>
            ${message}
        </p>
        
    </body>
</html>
