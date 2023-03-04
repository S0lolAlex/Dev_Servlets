package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/time")
public class TimeServlet extends HttpServlet {
    private String time_zone;

        @Override
        protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            time_zone = req.getParameter("timezone");
            String time = new Time().getTime(time_zone);
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write(time);
            resp.getWriter().close();
        }
}