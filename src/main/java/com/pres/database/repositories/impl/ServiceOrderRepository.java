package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;
import com.pres.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiceOrderRepository implements Repository {

    public void setServiceOrder(List<Service> basket){

        OrderRepository or = new OrderRepository();

        try (Connection connection = getConnection()) {
        for (Service i: basket) {
            PreparedStatement statement = connection.prepareStatement("insert into db_construction_firm.service_order (service_id, order_id) values (?,?);");
            int j = 0;
            int q = i.getService_id();
            int w = or.getLastOrderId();
            statement.setInt(++j, i.getService_id());
            statement.setInt(++j, or.getLastOrderId());
            statement.execute();
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
