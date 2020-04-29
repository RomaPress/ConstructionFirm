package com.pres.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LoggingInServlet extends HttpServlet {

    private List<String> firstList;

    @Override
    public void init(){
        firstList = new CopyOnWriteArrayList<>();
        firstList.add("Select books by author");
        firstList.add("Select books by genre");

    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        HttpSession session = req.getSession();

        session.setAttribute("firstList", firstList);
        req.getRequestDispatcher("/WEB-INF/view/loggingIn.jsp").forward(req, resp);


    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        req.getRequestDispatcher("/WEB-INF/view/loggingIn.jsp").forward(req, resp);

        String Q = req.getParameter("name");

        switch (req.getParameter("name")) {
            case ("customer"):
                req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);

                break;
            case ("admin"):
                req.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(req, resp);
                break;
        }
    }


}