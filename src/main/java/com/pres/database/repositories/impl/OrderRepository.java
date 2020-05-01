package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderRepository  implements Repository {

    public void setOrder(){
        CustomerRepository cs = new CustomerRepository();
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("insert into db_construction_firm.\"order\" (date, status_id, customer_id) values (current_date, ?,?);");
            int i = 0;
            statement.setInt(++i, 1);
            statement.setInt(++i, cs.getLastCustomerId());

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastOrderId() {
        int result = 0;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select max(order_id) as order_id  from db_construction_firm.\"order\" group by order_id;");
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt(1);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
