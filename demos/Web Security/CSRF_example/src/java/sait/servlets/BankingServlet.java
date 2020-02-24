package sait.servlets;

import java.io.IOException;
import java.util.UUID;
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

        // user is logged in now
        String amount = request.getParameter("amount");
        if (amount == null) {
            // form is displayed for the first time
            // generate nonce here for the form and session
            String nonce = UUID.randomUUID().toString();
            // store nonce in request for the form
            request.setAttribute("nonceForm", nonce);
            // store nonce in session for the server
            session.setAttribute("nonceSession", nonce);

            getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
            return;
        }

        // CSRF protection
        // ensure nonce from form == nonce from session
        String nonceForm = request.getParameter("nonceForm");
        String nonceSession = (String) session.getAttribute("nonceSession");

        if (nonceForm == null || nonceSession == null) {
            throw new SecurityException("CSRF protection: Nonce values must not be empty");
        }

        if (!nonceForm.equals(nonceSession)) {
            throw new SecurityException("CSRF protection: Nonce values are not equal.  Hacker attempt!");
        }

        // user has enter an amount in the text box
        float fAmount = Float.parseFloat(amount);
        float currentBalance = (Float) session.getAttribute("balance");

        if (fAmount <= currentBalance) {
            currentBalance = currentBalance - fAmount;
        }

        session.setAttribute("balance", currentBalance);

        // CSRF protection: generate a new nonce for the next request
        // generate nonce here for the form and session
        String nonce = UUID.randomUUID().toString();
        // store nonce in request for the form
        request.setAttribute("nonceForm", nonce);
        // store nonce in session for the server
        session.setAttribute("nonceSession", nonce);

        getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
