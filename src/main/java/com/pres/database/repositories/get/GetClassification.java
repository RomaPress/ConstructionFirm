package com.pres.database.repositories.get;

import com.pres.database.repositories.Repository;
import com.pres.model.Classification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetClassification implements Repository {

    public List<String> getNameClassification(){
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

    public List<Classification> geClassification(){
        List<Classification> result = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select * from db_construction_firm.classification ;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Classification classification = new Classification();
                classification.setClassification_id(rs.getInt("classification_id"));
                classification.setName_classification(rs.getString("name_classification"));
                result.add(classification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
