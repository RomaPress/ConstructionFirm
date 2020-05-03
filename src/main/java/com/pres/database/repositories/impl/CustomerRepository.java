package com.pres.database.repositories.impl;

import com.pres.database.repositories.Repository;
import com.pres.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository implements Repository {
    public void setCustomer(Customer customer) {
        try (Connection connection = getConnection()) {

            PreparedStatement statement = connection.prepareStatement("insert into db_construction_firm.customer  (first_name, last_name, patronymic, phone_number) values(?,?,?,?)");
            int i = 0;
            statement.setString(++i, customer.getFirst_name());
            statement.setString(++i, customer.getLast_name());
            statement.setString(++i, customer.getPatronymic());
            statement.setInt(++i, customer.getPhone_number());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getLastCustomerId() {
        int result = 0;
        int count = 0;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select max(customer_id) as customer_id from db_construction_firm.customer;");
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
