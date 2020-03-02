package sait.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BankingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("username") == null) {
            response.sendRedirect("index.html");
            return;
        }
        
        String amount = request.getParameter("amount");
        if (amount == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
            return;
        }        
                
        float fAmount = Float.parseFloat(amount);
        float currentBalance = (Float)session.getAttribute("balance");

        if (fAmount <= currentBalance)
            currentBalance = currentBalance - fAmount;

        session.setAttribute("balance", currentBalance);

        getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
