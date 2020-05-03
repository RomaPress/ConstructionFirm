package com.pres.servlet;

import com.pres.database.repositories.get.GetOrder;
import com.pres.database.repositories.impl.OrderRepository;
import com.pres.database.repositories.impl.ServiceRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GetOrder ordersId = new GetOrder();
        ServiceRepository orderedService = new ServiceRepository();
        OrderRepository order = new OrderRepository();

        req.setAttribute("order", order.orderInfo(orderedService.getOrderedService(ordersId.getOrderId())));
        req.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(req, resp);
    }


}
