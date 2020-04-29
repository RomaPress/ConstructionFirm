package com.pres.database.repositories.get;

import com.pres.database.repositories.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetClassification implements Repository {

    public List<String> getClassification(){
        List<String> result = new ArrayList<>();
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select name_classification from db_construction_firm.classification ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result.add(rs.getString("name_classification"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
