/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sait.businesslogic.UserService;
import sait.domainmodel.User;

/**
 *
 * @author 186303
 */

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String message = request.getParameter("message");
        request.setAttribute("message", message);
        
        UserService us = new UserService();
        
        List userList = null;
        try {
            userList = us.getAll();
        } catch (Exception ex) {
            request.setAttribute("message", ex.toString());
        }
        
        request.setAttribute("users", userList);
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
    
    @Override            
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService us = new UserService();
        
        if (action == null)
        {
            action = "";
        }
        switch (action) {
            case "view":
                try {
                    User selectedUser = us.get(username);
                    request.setAttribute("selectedUser", selectedUser);
                } catch (Exception ex) {
                }   break;
            case "add":
                try {
                    us.insert(username, firstname, lastname, email, password);
                    request.setAttribute("message", "User added.");
                } catch (Exception ex) {
                    request.setAttribute("message", "Error: User could not be added!"); 
            }   break;
            case "delete":
                try {
                    us.delete(username);
                    request.setAttribute("message", "User deleted.");
                } catch (Exception ex) {
                    request.setAttribute("message", "Error: User could not be deleted!");
                }   break;
            case "edit":
                try {
                    us.update(username, firstname, lastname, email, password);
                    request.setAttribute("message", "User updated.");
                } catch (Exception ex) {
                    request.setAttribute("message", "Error: User could not be updated!");
            }   break;
            default:
                break;
        }
        
        try {
            List<User> users = us.getAll();
            request.setAttribute("users", users);
        } catch (Exception ex) {
            
        }
        
        request.getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }
}
