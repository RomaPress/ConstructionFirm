package com.pres.database.repositories;

import com.pres.database.ConnectionFactory;

import java.sql.Connection;

public interface Repository {

    default Connection getConnection() {
        return ConnectionFactory.getConnection();
    }
}
