package calculator.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {

    @Override
    public void init() {
        // Servlet initialization
        System.out.println("CalculatorServlet initialized");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));
            String operation = request.getParameter("operation");

            double result = 0;

            switch (operation) {
                case "add":
                    result = num1 + num2;
                    break;
                case "sub":
                    result = num1 - num2;
                    break;
                case "mul":
                    result = num1 * num2;
                    break;
                case "div":
                    if (num2 == 0) {
                        out.println("<h3>Error: Division by zero</h3>");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            // Store result in session
            HttpSession session = request.getSession();
            session.setAttribute("lastResult", result);

            out.println("<html><body>");
            out.println("<h2>Calculation Result</h2>");
            out.println("<p>Result: <b>" + result + "</b></p>");
            out.println("<a href='index.html'>Back</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<h3>Error: Invalid input</h3>");
            out.println("<a href='index.html'>Back</a>");
        }
    }

    @Override
    public void destroy() {
        // Cleanup resources
        System.out.println("CalculatorServlet destroyed");
    }
}
