<%-- 
    Document   : home
    Created on : 10-Nov-2017, 1:48:42 PM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        
        <h2>Hi ${username}</h2>
        <script>
            alert("hi ${username}");
        </script>
        <a href="users">Manage Users</a><br>
        <a href="login?logout">Logout</a>
    </body>
</html>
