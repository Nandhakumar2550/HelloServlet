package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/validateName")
public class NameValidationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");

        PrintWriter out = response.getWriter();

        String regex = "^[A-Z][a-zA-Z]{2,}$";

        if(name.matches(regex)){
            out.println("<h2>Name is Valid</h2>");
            out.println("<h3>Welcome " + name + "</h3>");
        } else {
            out.println("<h2>Invalid Name</h2>");
            out.println("<p>Name must start with Capital Letter and have minimum 3 characters.</p>");
        }

        out.close();
    }
}
