package com;

import java.sql.*;

public class SQLExecuter {
    public static void select(String SQL) {
        Statement statement = null;
        ResultSet resultSets = null;
        try {
            statement = MyDriver.createConnection().createStatement();
            resultSets = statement.executeQuery(SQL);

            while (resultSets.next()) {
                for (int i = 1; i <= resultSets.getMetaData().getColumnCount(); i++) {
                    Object object = resultSets.getObject(i);
                    String name = resultSets.getMetaData().getColumnName(i);
                    System.out.println(name + " " + object);
                }
                System.out.println("===================");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }finally {
            try {
                if (statement.getConnection()!=null){
                     statement.getConnection().close();
                    System.out.println("connection is closed");
                }
                if (statement!=null){
                    statement.close();
                    System.out.println("statement is closed");
                }
                if (resultSets!=null){
                   resultSets.close();
                    System.out.println("results set is closed");
               }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    static void updateAndInsert(String SQL) {
        Statement statement = null;
        try{
            statement = MyDriver.createConnection().createStatement();
            statement.executeUpdate(SQL);
            System.out.println("QUERY: OK");
        }catch (SQLException e){
            System.out.println(e);
        }finally {
            try {
                if(statement.getConnection()!=null) {
                    statement.getConnection().close();
                    System.out.println("connection is closed");
                }
                if (statement!=null){
                    statement.close();
                    System.out.println("statement is closed");
                }
            }catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}

