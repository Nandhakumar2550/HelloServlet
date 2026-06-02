package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validatePassword")
public class PasswordValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String password = request.getParameter("password");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*[@#$%^&+=!].*[@#$%^&+=!]).{8,}$";

        if(password.matches(regex)) {

            out.println("<h2>Password is Valid</h2>");

        } else {

            out.println("<h2>Password is Invalid</h2>");
            out.println("<p>Password must contain:</p>");
            out.println("<ul>");
            out.println("<li>Minimum 8 Characters</li>");
            out.println("<li>At least 1 Uppercase Letter</li>");
            out.println("<li>At least 1 Number</li>");
            out.println("<li>Exactly 1 Special Character</li>");
            out.println("</ul>");
        }

        out.close();
    }
}
