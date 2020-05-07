package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;
import com.pres.model.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ServiceRepository implements Repository {


    public Service getServiceNameByServiceId(int service_id) {

        Service service = new Service();

        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select name_service, service_id from db_construction_firm.service where service_id = ?;");

            statement.setInt(1, service_id);
            statement.execute();
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                service.setService_id(rs.getInt("service_id"));
                service.setName_service(rs.getString("name_service"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public Map<Integer, List<Service>> getOrderedService(List<Integer> order_id) {

        Map<Integer, List<Service>> result = new HashMap<>();
        try (Connection connection = getConnection()) {
            for (Integer i : order_id) {
                PreparedStatement statement = connection.prepareStatement("select sro.order_id, sr.service_id, sr.name_service, un.name_unit, sro.amount from db_construction_firm.service sr left join db_construction_firm.unit un on sr.unit_id = un.unit_id   right join db_construction_firm.service_order sro on sr.service_id = sro.service_id where sro.order_id = ?;");
                statement.setInt(1, i);
                ResultSet rs = statement.executeQuery();

                List<Service> orderedService = new ArrayList<>();
                while (rs.next()) {
                    Service service = new Service();
                    service.setService_id(rs.getInt("service_id"));
                    service.setName_service(rs.getString("name_service"));
                    service.setName_unit(rs.getString("name_unit"));
                    service.setAmount(rs.getFloat("amount"));
                    orderedService.add(service);
                }
                result.put(i, orderedService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setService(int classification_id, String name_service, float unit_price, int unit_id){
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("insert into db_construction_firm.service  ( classification_id, name_service, unit_price, unit_id) values(?,?,?,?);");

            statement.setInt(1, classification_id);
            statement.setString(2, name_service);
            statement.setFloat(3, unit_price);
            statement.setInt(4, unit_id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

