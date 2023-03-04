package org.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/time")
public class TimezoneValidateFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        if (!req.getParameterMap().containsKey("timezone")) {
            chain.doFilter(req, res);
            return;
        }

        if (Time.isTimeZoneValid(req.getParameter("timezone"))) {
            chain.doFilter(req, res);
        } else {
            res.setStatus(400);
            res.getWriter().write("Invalid timezone");
            res.getWriter().close();
        }
    }
}
