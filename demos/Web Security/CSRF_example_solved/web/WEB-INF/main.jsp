<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CSRF Example Main Page</title>
    </head>
    <body>
        <h1>CSRF Example Main Page</h1>
        <a href="login?logout">Logout</a>
        
        <h2>Bob's ATM</h2>
        <form action="banking" method="get">
            Amount to withdraw: <input type="text" name="amount"><br/>
            <input type="hidden" name="nonceForm" value="${nonceForm}">
            <input type="submit" value="Withdraw">
        </form>
        
        Balance: <c:out value="${balance}" />
    </body>
</html>
