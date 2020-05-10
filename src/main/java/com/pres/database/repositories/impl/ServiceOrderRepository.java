package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;
import com.pres.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ServiceOrderRepository implements Repository {

    public void setServiceOrder(List<Service> basket) {

        OrderRepository or = new OrderRepository();

        try (Connection connection = getConnection()) {
            for (Service i : basket) {
                PreparedStatement statement = connection.prepareStatement("insert into db_construction_firm.service_order (service_id, order_id) values (?,?);");
                int j = 0;
                statement.setInt(++j, i.getService_id());
                statement.setInt(++j, or.getLastOrderId());
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSomeService(int order_id, int service_id) {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("delete from db_construction_firm.service_order where order_id = ? and service_id = ?;");

            statement.setInt(1, order_id);
            statement.setInt(2, service_id);

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAmount(int order_id, int service_id, float amount) {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("update db_construction_firm.service_order set amount = ? where order_id = ? and service_id = ?;");

            if (amount < 0) amount = 0;

            statement.setFloat(1, amount);
            statement.setInt(2, order_id);
            statement.setInt(3, service_id);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
