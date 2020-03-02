/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sait.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sait.businesslogic.AccountService;

/**
 *
 * @author awarsyle
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String message = request.getParameter("message");
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String message = request.getParameter("message");
        
        AccountService as = new AccountService();
        try {
            if (as.login(request, username, password)) {
                response.sendRedirect("home");
            } else {
                request.setAttribute("loginMessage", "Invalid login");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("loginMessage", "Error: " + ex.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }       
    }
}
