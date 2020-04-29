package com.pres;

import com.pres.database.ConnectionFactory;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionFactory.getConnection();
    }
}