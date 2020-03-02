<%-- 
    Document   : login
    Created on : 10-Nov-2015, 8:30:59 AM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="login">
            user name: <input type="text" name="username" /><br />
            password: <input type="password" name="password" /><br />
            <input type="submit" value="Login" /><br />
            ${loginMessage}
        </form>        
    </body>
</html>
