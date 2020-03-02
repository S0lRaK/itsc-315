<%-- 
    Document   : users
    Created on : 20-Oct-2015, 11:18:59 AM
    Author     : awarsyle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        <h3>Hi ${currentUser.firstName}</h3>
        <p>
            <a href="home">Home</a> | <a href="home?action=logout">Logout</a>
        </p>
        <h2>Users</h2>
        <div id="main">
            <div id="users">
                <table>
                    <tr>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Notes</th>
                        <th>Delete</th>
                        <th>Edit</th>
                    </tr>

                    <c:forEach var="item" items="${users}">
                        <tr>
                            <td>${item.userName}</td>
                            <td>${item.firstName}</td>
                            <td>${item.lastName}</td>
                            <td>${item.email}</td>
                            <td>${item.password}</td>
                            
                            <td>
                              <form action="users" method="post">
                                  <input type="hidden" name="username" value="${item.userName}">
                                  <input type="hidden" name="action" value="delete">
                                  <input type="submit" value="Delete">
                              </form>
                            </td>
                            <td>
                              <form action="users" method="post">
                                  <input type="hidden" name="username" value="${item.userName}">
                                  <input type="hidden" name="action" value="view">
                                  <input type="submit" value="Edit">
                              </form>
                          </td>

                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
        
        <c:if test="${selectedUser == null}">
            <div>
                <h2>Add User</h2>
                <form method="post" action="users">
                    <div class="fieldset">
                        <label for="username">Username:</label>
                        <input type="text" name="username" id="username" />
                    </div>
                    <div class="fieldset">
                        <label for="username">First Name:</label>
                        <input type="text" name="firstname" id="firstname" />
                    </div>
                    <div class="fieldset">
                        <label for="username">Last Name:</label>
                        <input type="text" name="lastname" id="lastname" />
                    </div>
                    <div class="fieldset">
                        <label for="password">Password:</label>
                        <input type="password" name="password" id="password" />
                    </div>
                    <div class="fieldset">
                        <label for="access">Email:</label>
                        <input type="text" name="email" id="email" />
                    </div>
                    <div class="fieldset">
                        <input type="hidden" name="action" value="add">
                        <input type="submit" value="Save"/>
                    </div>
                </form>
                ${message}
            </div>
        </c:if>
                                      
        <c:if test="${selectedUser != null}">
            <div id="formBox" class="leftSideBox">
                <h2>Edit ${selectedUser.userName}</h2>
                <form method="post" action="users">
                    <div class="fieldset">
                        <label for="username">Username:</label>
                        <input type="text" name="username" id="username" value="${selectedUser.userName}" readonly="readonly"/>
                    </div>
                    <div class="fieldset">
                        <label for="username">First Name:</label>
                        <input type="text" name="firstname" id="firstname" value="${selectedUser.firstName}" />
                    </div>
                    <div class="fieldset">
                        <label for="username">Last Name:</label>
                        <input type="text" name="lastname" id="lastname" value="${selectedUser.lastName}" />
                    </div>
                    <div class="fieldset">
                        <label for="password">Password:</label>
                        <input type="password" name="password" id="password" value="${selectedUser.password}" />
                    </div>
                    <div class="fieldset">
                        <label for="access">Email:</label>
                        <input type="text" name="email" id="email" value="${selectedUser.email}" />
                    </div>
                    <div class="fieldset">
                        <input type="hidden" name="action" value="edit">
                        <input type="submit" value="Save"/>
                    </div>
                </form>
                ${message}
            </div>
        </c:if>
    </body>
</html>
