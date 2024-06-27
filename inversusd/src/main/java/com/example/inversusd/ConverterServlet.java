package com.example.inversusd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConverterServlet", value = "/convert")
public class ConverterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rateStr = req.getParameter("rate");
        String usdStr = req.getParameter("usd");

        if (rateStr != null && usdStr != null) {
            try {
                float rate = Float.parseFloat(rateStr.trim());
                float usd = Float.parseFloat(usdStr.trim());
                float vnd = rate * usd;

                PrintWriter writer = resp.getWriter();
                writer.println("<html>");
                writer.println("<h1>Rate: " + rate + "</h1>");
                writer.println("<h1>USD: " + usd + "</h1>");
                writer.println("<h1>VND: " + vnd + "</h1>");
                writer.println("</html>");
            } catch (NumberFormatException e) {
                resp.getWriter().println("Invalid input format. Please enter valid numbers for rate and USD.");
            }
        } else {
            resp.getWriter().println("Rate and USD parameters are required.");
        }
    }
}
