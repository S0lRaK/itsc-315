package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("cmd /c echo " + name);
        
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        
        String line;
        PrintWriter writer = response.getWriter();
        writer.println("<h2>Hello " + stdInput.readLine() + "</h2>");
        while ((line = stdInput.readLine()) != null) {
            writer.println(line);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // not implemented
    }
}
