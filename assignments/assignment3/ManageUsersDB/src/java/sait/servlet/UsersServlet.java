package sait.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sait.db.UsersDB;
import sait.domain.User;

public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login?message=Not logged in!");
            return;
        }
        
        String currentUser = session.getAttribute("username").toString();
        
        String message=request.getParameter("message");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String delete=request.getParameter("delete");
        
        //Handle adding a user
        if (username!=null && password!=null && !username.equals("") && !password.equals("") && Pattern.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", password))
        {
            try {
                UsersDB.addUser(username, password);
                request.setAttribute("message", "User added to database");
            } catch (Exception ex) {
                request.setAttribute("message", "error");
            }
        }
        
        //Handle deleting user
        else if (delete != null)
        {
            if (UsersDB.isAdmin(currentUser)) {
                try {
                UsersDB.deleteUser(username);
                request.setAttribute("message", "User deleted from database");
                } catch (Exception ex) {
                    request.setAttribute("message", "error");
                }
            }
            
        }
        
        List<User> users;
        try {
            users = UsersDB.getUsers();
            if (!UsersDB.isAdmin(currentUser)) {
                for (User user : users) {
                    user.setPassword("****");
                }
            }
            request.setAttribute("users", users);
        } catch (Exception ex) {
            Logger.getLogger(UsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        getServletContext().getRequestDispatcher("/WEB-INF/mainpage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // not implemented
    }
}
