package com.poolborges.example.undertow;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PauloBorges
 */
public class MessageServlet extends HttpServlet {

    public static final String MESSAGE = "message";
    private String message;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        message = config.getInitParameter(MESSAGE);
    }

    @Override
    protected void doGet(final HttpServletRequest req,
            final HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<title>Example</title>");
        out.println("<body>");
        out.println("<h1>Hello Servlet Get</h1>");
        out.println("<p>" + message + "</p>");

        String DATA = req.getParameter("DATA");
        if (DATA != null) {
            out.println(DATA);
        } else {
            out.println("No ?DATA= entered.");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(final HttpServletRequest req,
            final HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
