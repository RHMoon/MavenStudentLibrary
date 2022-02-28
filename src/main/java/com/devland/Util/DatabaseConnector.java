package com.devland.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final String url ="jdbc:postgresql://localhost/student_library";
    private final String user = "macbookair";
    private final String password = "";

    public Connection connect() {
        Connection conn = null;
    
            try {
    
                conn = DriverManager.getConnection(url, user, password);
    
                System.out.println("Connected to the PostgreSQL server successfully.");
    
            } catch (SQLException e) {
    
                System.out.println(e.getMessage());
    
            }
    
            return conn;
    }
    
}
