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

    public boolean searchCustomer(String first_name, String last_name, String patronymic, int phone_number) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  count(1) as count  from db_construction_firm.customer where first_name = ? and last_name = ? and patronymic = ? and phone_number = ?;");
            int i = 0;
            int result;
            statement.setString(++i, first_name);
            statement.setString(++i, last_name);
            statement.setString(++i, patronymic);
            statement.setInt(++i, phone_number);
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt(1);
            if (result == 1) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public int searchCustomerId(String first_name, String last_name, String patronymic, int phone_number) {
        int result = 0;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select  customer_id from db_construction_firm.customer where first_name = ? and last_name = ? and patronymic = ? and phone_number = ?;");
            int i = 0;

            statement.setString(++i, first_name);
            statement.setString(++i, last_name);
            statement.setString(++i, patronymic);
            statement.setInt(++i, phone_number);
            ResultSet rs = statement.executeQuery();
            rs.next();
            result = rs.getInt("customer_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}