package com.pres.servlet;

import com.pres.database.repositories.get.GetClassification;
import com.pres.database.repositories.get.GetService;
import com.pres.database.repositories.get.GetUnit;
import com.pres.database.repositories.impl.ClassificationRepository;
import com.pres.database.repositories.impl.ServiceRepository;
import com.pres.database.repositories.impl.UnitRepository;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ServiceCatalogServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetService serviceTable = new GetService();

        HttpSession session = req.getSession();

        GetUnit unit = new GetUnit();
        GetClassification classification = new GetClassification();




        session.setAttribute("unit", unit.getUnit());
        session.setAttribute("classification", classification.geClassification());
        session.setAttribute("serviceTable", serviceTable.getService());
        req.getRequestDispatcher("/WEB-INF/view/serviceCatalog.jsp").forward(req, resp);

    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        if (req.getParameterMap().containsKey("addService")) {

            if (req.getParameter("name_service").equals("") || req.getParameter("unit_price").equals("") || Float.parseFloat(req.getParameter("unit_price")) <= 0) {
                req.getRequestDispatcher("/WEB-INF/view/serviceCatalog.jsp").forward(req, resp);
            } else {
                ClassificationRepository cr = new ClassificationRepository();
                UnitRepository ur = new UnitRepository();
                ServiceRepository sr = new ServiceRepository();

                sr.setService(cr.getClassificationId(req.getParameter("classification")), req.getParameter("name_service"), Float.parseFloat(req.getParameter("unit_price")), ur.getUnitId(req.getParameter("unit")));
                doGet(req, resp);
            }
        }
        if (req.getParameterMap().containsKey("delete")) {
            ServiceRepository sr = new ServiceRepository();
            sr.deleteService(Integer.parseInt(req.getParameter("service_id")));
            doGet(req, resp);
        }
        if (req.getParameterMap().containsKey("change")) {

            if (Float.parseFloat(req.getParameter(req.getParameter("service_id"))) <= 0) {
                req.getRequestDispatcher("/WEB-INF/view/serviceCatalog.jsp").forward(req, resp);
            } else {
                ServiceRepository sr = new ServiceRepository();
                sr.updateUnitPrice(Integer.parseInt(req.getParameter("service_id")), Float.parseFloat(req.getParameter(req.getParameter("service_id"))));
                doGet(req, resp);
            }
        }
    }
}