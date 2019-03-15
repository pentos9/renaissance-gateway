package com.spacex.renaissance.gateway.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "renaissance", urlPatterns = "/*")
public class RenaissanceServlet extends HttpServlet {
    private RenaissanceRunner renaissanceRunner = new RenaissanceRunner();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        renaissanceRunner.init(req, resp);
        try {
            renaissanceRunner.preRoute();
            renaissanceRunner.route();
            renaissanceRunner.postRoute();
        } catch (Exception ex) {
            ex.printStackTrace();
            RequestContext.getCurrentContext().getResponse().sendError(HttpServletResponse.SC_NOT_FOUND, ex.getMessage());
        } finally {
            RequestContext.getCurrentContext().unset();
        }

    }
}
