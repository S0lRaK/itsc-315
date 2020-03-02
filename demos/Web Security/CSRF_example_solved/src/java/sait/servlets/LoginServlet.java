package sait.servlets;

import java.io.IOException;

import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String logout=request.getParameter("logout");
        
        if (logout != null) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
        
        response.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        
        if (username != null && password != null && username.equals("user") && password.equals("pass")) {
            HttpSession session = request.getSession(); //CREATE NEW SESSION
            
            session.setAttribute("username", username); //Username
            session.setAttribute("balance", 1000.00f); // get balance from database ...
            
            response.sendRedirect("banking");
        }
        else {
            response.sendRedirect("index.html");
        }
    }
}
