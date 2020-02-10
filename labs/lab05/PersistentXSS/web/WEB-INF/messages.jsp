<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Persistent XSS - Main Page</title>
    </head>
    <body>
        <h1>Persistent XSS - Main Page</h1>
        
        Hello, ${username}<br/>
        <a href="home">Refresh</a><br>
        <a href="login?action=logout">Logout</a><br/>

        <form action="home" method="get" id="myform">
        Post message: <input type="text" name="message">
        <input type="submit" value="Submit">
        </form>

        ${message}

        <h4>All Messages</h4>
        <div id="messages">
            <c:forEach items="${messages}" var="m">
                ${m} <br>
            </c:forEach>
        </div>
        
    </body>
</html>
