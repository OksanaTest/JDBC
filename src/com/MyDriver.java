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
    static Statement createConnection(){
        Connection connection = null;
        Statement statement = null;
        try {
            MyDriver.LoadDriver();
            connection = DriverManager.getConnection(DATABASE_URL + USER + PASSWORD);
            statement = connection.createStatement();
        }catch (SQLException e){
            System.out.println(e);}
        System.out.println(statement);
        return statement;
    }
    static ResultSet createResultSetForSelect(String SQL) throws SQLException{
            return createConnection().executeQuery(SQL);
    }
    static int createForUpdate(String SQL) throws SQLException{
        return createConnection().executeUpdate(SQL);

    }
    static void closeConnection() throws SQLException{
        createConnection().getConnection().close();
        createConnection().close();
    }
}
