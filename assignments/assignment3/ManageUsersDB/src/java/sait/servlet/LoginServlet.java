package sait.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sait.db.UsersDB;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String logout = request.getParameter("logout");
        request.setAttribute("message", request.getParameter("message"));
        
        if (logout != null) {
            HttpSession session = request.getSession();
            session.invalidate();
            request.setAttribute("message", "Logged out");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            if (UsersDB.validate(username, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                
                boolean isAdmin = UsersDB.isAdmin(username);
                session.setAttribute("isAdmin", isAdmin);
                
                response.sendRedirect("users");
                return;
            } else {
                request.setAttribute("message", "Invalid username or password!");
            }
        } else {
            request.setAttribute("message", "Both username and password are required!");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
