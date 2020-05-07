package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassificationRepository implements Repository {

    public int getClassificationId(String name_classification){

        int result = 0;
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("select classification_id from db_construction_firm.classification where name_classification = ?;");
            statement.setString(1, name_classification);
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt("classification_id");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }
}
