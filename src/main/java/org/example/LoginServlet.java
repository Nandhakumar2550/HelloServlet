package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("user");
        String password = request.getParameter("pwd");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        if ("admin".equals(username) &&
                "admin123".equals(password)) {

            out.println("<html><body>");
            out.println("<h2>Login Successful</h2>");
            out.println("<h3>Welcome " + username + "</h3>");
            out.println("</body></html>");

        } else {

            out.println("<html><body>");
            out.println("<h2>Login Failed</h2>");
            out.println("<h3>Invalid Username or Password</h3>");
            out.println("</body></html>");
        }

        out.close();
    }
}
