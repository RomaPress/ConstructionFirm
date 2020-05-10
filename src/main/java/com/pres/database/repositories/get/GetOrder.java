package com.pres.database.repositories.get;

import com.pres.database.repositories.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetOrder implements Repository{

    public List<Integer> getOrderId(){
        List<Integer> result = new ArrayList<>();

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select order_id from db_construction_firm.\"order\" ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(rs.getInt ("order_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Integer> getOrderIdByStatus(int status_id){
        List<Integer> result = new ArrayList<>();

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select order_id from db_construction_firm.\"order\" where status_id = ? ");
            statement.setInt(1, status_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(rs.getInt ("order_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
