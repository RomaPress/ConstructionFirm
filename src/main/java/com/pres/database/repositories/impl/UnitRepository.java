package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitRepository implements Repository {

    public int getUnitId(String name_unit){

        int result = 0;
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select unit_id from db_construction_firm.unit where name_unit = ?;");
            statement.setString(1, name_unit);
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt("unit_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
