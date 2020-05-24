package com.pres.servlet;

import com.pres.database.repositories.get.GetStatus;
import com.pres.database.repositories.impl.OrderRepository;
import com.pres.database.repositories.impl.ServiceOrderRepository;
import com.pres.database.repositories.impl.ServiceRepository;
import com.pres.database.repositories.impl.StatusRepository;
import com.pres.model.Order;
import com.pres.model.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateServlet extends HttpServlet {

    private List<Order> updateOrder = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> updateOrderId = new ArrayList<>();
        ServiceRepository orderedService = new ServiceRepository();
        OrderRepository orderRepository = new OrderRepository();

        GetStatus status = new GetStatus();

        if (req.getParameterMap().containsKey("update")) {
            updateOrderId.add(Integer.parseInt(req.getParameter("order_id")));

        } else {
            updateOrderId.add(updateOrder.get(0).getOrder_id());
        }
        if (updateOrder.size() > 0) {
            updateOrder.clear();
        }

        updateOrder.addAll(orderRepository.orderInfo(orderedService.getOrderedService(updateOrderId)));

        req.setAttribute("status", status.getStatus());
        req.setAttribute("updateOrder", updateOrder);
        req.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");
        if (req.getParameterMap().containsKey("delete")) {

            ServiceOrderRepository delete = new ServiceOrderRepository();
            delete.deleteSomeService(updateOrder.get(0).getOrder_id(), Integer.parseInt(req.getParameter("service_id")));
        }
        if (req.getParameterMap().containsKey("change")) {

            ServiceOrderRepository update = new ServiceOrderRepository();
            update.updateAmount(updateOrder.get(0).getOrder_id(), Integer.parseInt(req.getParameter("service_id")), Float.parseFloat(req.getParameter(req.getParameter("service_id"))));
            OrderRepository orderRepository = new OrderRepository();
            for (Order i : updateOrder) {
                orderRepository.setPrice(i.getPrice(), updateOrder.get(0).getOrder_id());
            }

        }
        if (req.getParameterMap().containsKey("changeStatus")) {

            StatusRepository sr = new StatusRepository();
            sr.changeStatus(sr.getStatusId(req.getParameter("status")), updateOrder.get(0).getOrder_id());
        }
        if (req.getParameterMap().containsKey("add")) {

            boolean valid = true;
            for (Service i : updateOrder.get(0).getOrderedServices()){
                if( i.getService_id() == Integer.parseInt(req.getParameter("service_id"))){
                    valid = false;
                }
            }
            if(valid){
                ServiceOrderRepository sor = new ServiceOrderRepository();
                sor.addServiceOrder(Integer.parseInt(req.getParameter("service_id")), updateOrder.get(0).getOrder_id());
            }
        }
        doGet(req, resp);
    }
}
