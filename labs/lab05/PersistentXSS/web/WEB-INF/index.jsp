<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persistent XSS -Login</title>
    </head>
    <body>
        <h1>Persistent XSS - Login</h1>
        
        <form action="" method="POST">
	Username: <input type="text" name="username" id="username"><br/>
	Password: <input type="password" name="password" id="password"><br/>
        <input type="submit" value="Login"><br>
        ${message}
</form>
    </body>
</html>
