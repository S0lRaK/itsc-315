package ca.sait.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // handle login
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if (username != null && (username.equals("abe") || username.equals("bob")) && password != null && password.equals("password")) {
            HttpSession session=request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("home");
            return;
        }
        
        // handle logout and default action
        String action = request.getParameter("action");
        
        
        if (action != null && action.equals("logout")) {
            HttpSession session=request.getSession();
            session.invalidate();
            request.setAttribute("message", "Logged out");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
