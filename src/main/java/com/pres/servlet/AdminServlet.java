package com.pres.servlet;

import com.pres.database.repositories.get.GetOrder;
import com.pres.database.repositories.impl.OrderRepository;
import com.pres.database.repositories.impl.ServiceRepository;
import com.pres.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminServlet extends HttpServlet {

    private List<Order> orderList = new ArrayList<>();


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (!orderList.isEmpty()) orderList.clear();

        GetOrder ordersId = new GetOrder();
        ServiceRepository orderedService = new ServiceRepository();
        OrderRepository order = new OrderRepository();

        if (req.getParameterMap().containsKey("sort")) {
            if (Integer.parseInt(req.getParameter("btn")) == 4)
                orderList.addAll(order.orderInfo(orderedService.getOrderedService(ordersId.getOrderId())));
            else {
                orderList.addAll(order.orderInfo(orderedService.getOrderedService(ordersId.getOrderIdByStatus(Integer.parseInt(req.getParameter("btn"))))));
            }
        } else {
            orderList.addAll(order.orderInfo(orderedService.getOrderedService(ordersId.getOrderId())));
        }
        Collections.sort(orderList);
        req.setAttribute("order", orderList);
        req.getRequestDispatcher("/WEB-INF/view/admin.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameterMap().containsKey("delete")) {

            OrderRepository delete = new OrderRepository();
            delete.deleteOrder(Integer.parseInt(req.getParameter("delete")));
            Order del = null;
            for (Order i : orderList) {
                if (i.getOrder_id() == Integer.parseInt(req.getParameter("delete"))) {
                    del = i;
                    break;
                }
            }
            orderList.remove(del);
        }
        doGet(req, resp);
    }
}
