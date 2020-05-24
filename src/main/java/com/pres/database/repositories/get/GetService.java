package com.pres.database.repositories.get;

import com.pres.database.repositories.Repository;
import com.pres.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetService implements Repository {
    public List<List<Service>> getService() {

        GetClassification cf = new GetClassification();

        List<List<Service>> allService = new ArrayList<>();

        try (Connection connection = getConnection()) {

            for (int i = 0; i < cf.getNameClassification().size(); i++) {

                PreparedStatement statement = connection.prepareStatement("select service_id, name_service, unit_price, un.name_unit  from db_construction_firm.service sr inner join  db_construction_firm.classification cl on sr.classification_id = cl.classification_id  inner join db_construction_firm.unit un on sr.unit_id = un.unit_id where name_classification = ? ");
                statement.setString(1, cf.getNameClassification().get(i));
                statement.execute();
                ResultSet rs = statement.executeQuery();
                List<Service> classificationService = new ArrayList<>();
                Service oneService;

                while (rs.next()) {
                    oneService = new Service();
                    oneService.setService_id(rs.getInt("service_id"));
                    oneService.setName_service(rs.getString("name_service"));
                    oneService.setUnit_price(rs.getFloat("unit_price"));
                    oneService.setName_unit("грн/" + rs.getString("name_unit"));

                    classificationService.add(oneService);
                }
                Collections.sort(classificationService);
                allService.add(classificationService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allService;
    }
}
