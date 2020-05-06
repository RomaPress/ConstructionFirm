package com.pres.database.repositories.get;

import com.pres.database.repositories.Repository;
import com.pres.model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetStatus implements Repository {

    public List<Status> getStatus() {

        List<Status> result = new ArrayList<>();

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select * from db_construction_firm.status;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Status status = new Status();
                status.setStatus_id(rs.getInt("status_id"));
                status.setName_status(rs.getString("name_status"));
                result.add(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
