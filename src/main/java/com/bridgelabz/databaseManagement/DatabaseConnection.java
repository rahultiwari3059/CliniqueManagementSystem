package com.bridgelabz.databaseManagement;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DatabaseConnection {

    private static final BasicDataSource dataSource = new BasicDataSource();

    static {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/CliniqueManagementSystem");
        dataSource.setUsername("root");
        dataSource.setPassword("bridgeit");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
}
}
