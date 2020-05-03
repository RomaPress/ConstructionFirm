package com.pres.servlet;

import com.pres.database.repositories.impl.CustomerRepository;
import com.pres.database.repositories.impl.OrderRepository;
import com.pres.database.repositories.impl.ServiceOrderRepository;
import com.pres.database.repositories.impl.ServiceRepository;
import com.pres.model.Customer;
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

        if(req.getParameterMap().containsKey("delete")) {
            Service del = null;
            for (Service i : ServiceToBasket) {
                if (i.getService_id() == Integer.parseInt(req.getParameter("delete"))) {
                    del = i;
                    break;
                }
            }
            ServiceToBasket.remove(del);
        }

        if(req.getParameterMap().containsKey("Ok")){
            final Customer customer = new Customer();
            customer.setFirst_name(req.getParameter("first_name"));
            customer.setLast_name(req.getParameter("last_name"));
            customer.setPatronymic(req.getParameter("patronymic"));
            customer.setPhone_number(Integer.parseInt(req.getParameter("phone_number")));

            CustomerRepository cr = new CustomerRepository();
            cr.setCustomer(customer);

            OrderRepository or = new OrderRepository();
            or.setOrder();

            ServiceOrderRepository sor = new ServiceOrderRepository();
            sor.setServiceOrder(ServiceToBasket);

            req.getRequestDispatcher("/WEB-INF/view/loggingIn.jsp").forward(req, resp);
        }


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


