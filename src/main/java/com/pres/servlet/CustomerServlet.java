package com.pres.servlet;

import com.pres.database.repositories.get.GetService;
import com.pres.database.repositories.impl.ServiceRepository;
import com.pres.model.Service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CustomerServlet extends HttpServlet {

    private List<Service> idToBasket = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GetService serviceTable = new GetService();
        HttpSession session = req.getSession();

        session.setAttribute("serviceTable", serviceTable.getService());
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
