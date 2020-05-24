package com.pres.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoggingInServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/loggingIn.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setCharacterEncoding("UTF-8");
        switch (req.getParameter("name")) {
            case ("customer"):
                resp.sendRedirect(req.getContextPath() + "/customer");
                break;
            case ("admin"):
                resp.sendRedirect(req.getContextPath() + "/admin");
                break;
        }
    }
}