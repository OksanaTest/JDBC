package com;

import java.sql.*;

class MyDriver {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test?";
    private static final String USER = "user=root&";
    private static final String PASSWORD = "password=11081108";
    private static void LoadDriver() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
    static Connection createConnection(){
        Connection connection = null;
        try {
            LoadDriver();
            connection = DriverManager.getConnection(DATABASE_URL + USER + PASSWORD);
        }catch (SQLException e){
            System.out.println(e);}
        return connection;
    }
}
