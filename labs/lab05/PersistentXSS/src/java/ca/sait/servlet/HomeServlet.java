/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.servlet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        
        if (username == null) {
            response.sendRedirect("login");
            return;
        }
        
        
        String message = request.getParameter("message");
        
        if (message != null && !message.equals(""))
        {
            String file = getServletContext().getRealPath("/WEB-INF/") + "/messages.txt";
            PrintWriter fout = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(file, true)));
            fout.println(username + ": " + message);
            fout.close();            
            request.setAttribute("message", "New message posted");
        }
        
        List<String> messages = getMessages();
        request.setAttribute("messages", messages);
        getServletContext().getRequestDispatcher("/WEB-INF/messages.jsp").forward(request, response);
    }
    
    public List<String> getMessages() throws FileNotFoundException
    {
        ArrayList<String> messages = new ArrayList<>();
        
        String file = getServletContext().getRealPath("/WEB-INF/") + "/messages.txt";
        
        File f = new File(file);
        try (Scanner s = new Scanner(f)) {
            while (s.hasNext())
            {
                messages.add(s.nextLine());
            }
        }
        
        return messages;
    }

    
}
