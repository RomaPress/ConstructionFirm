package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusRepository implements Repository {

    public int getStatusId(String name_status) {
        int result = 0;
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select status_id from db_construction_firm.status where name_status = ?;");
            statement.setString(1, name_status);
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt("status_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void changeStatus(int status_id, int order_id) {

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update db_construction_firm.\"order\" set status_id = ? where order_id = ? ;");

            statement.setInt(1, status_id);
            statement.setInt(2, order_id);
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
