package com.pres.servlet;

import com.pres.database.repositories.impl.ServiceRepository;
import com.pres.model.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasketServlet extends HttpServlet {

    private List<Service> ServiceToBasket = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("ServiceToBasket", ServiceToBasket);
        req.getRequestDispatcher("/WEB-INF/view/basket.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


        ServiceRepository oneService = new ServiceRepository();

        ServiceToBasket.add(oneService.getServiceNameByServiceId(Integer.parseInt(req.getParameter("id"))));

        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
