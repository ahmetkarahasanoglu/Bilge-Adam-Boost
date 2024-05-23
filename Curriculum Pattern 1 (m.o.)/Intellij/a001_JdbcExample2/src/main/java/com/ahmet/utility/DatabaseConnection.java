package com.ahmet.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance = null; // Singleton yaptık sınıfımızı.
    public static final String dbName = "futbolapp";
    private static final String url = "jdbc:postgresql://localhost:5432/" + dbName;
    private static final String username = "postgres";
    private static final String password = "root";
    private static Connection connection;

    // CONSTRUCTOR:
    private DatabaseConnection() { // constructor'ı private yaptık, ulaşılamasın diye. (singleton gereği).
    }

    public static DatabaseConnection getInstance() { // singleton'ı sağlayan metot
        if(instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public static Connection getConnection() throws Exception {
        if(connection==null || connection.isClosed()) { // 'connection.isClosed()' is effective when we open connection second time on the same 'main' method. [teacher removed this line completely, code still worked]
            try {
                connection = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }



}//CLASS ENDS HERE ----
