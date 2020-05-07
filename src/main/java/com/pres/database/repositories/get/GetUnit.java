package com.pres.database.repositories.get;

import com.pres.database.repositories.Repository;
import com.pres.model.Status;
import com.pres.model.Unit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetUnit implements Repository {

    public List<Unit> getUnit() {

        List<Unit> result = new ArrayList<>();

        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select * from db_construction_firm.unit;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Unit unit  = new Unit();
                unit.setUnit_id(rs.getInt("unit_id"));
                unit.setName_unit(rs.getString("name_unit"));
                result.add(unit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
