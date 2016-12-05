package com;

import java.sql.*;

public class SQLExecuter {
    public static void select(String SQL) {
        try {
            ResultSet resultSets = MyDriver.createResultSetForSelect(SQL);

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
                MyDriver.closeConnection();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    static void updateAndInsert(String SQL){;
            try{
                if((MyDriver.createForUpdate(SQL)== 0) || (MyDriver.createForUpdate(SQL)== 1)){;
                System.out.println("QUERY: OK");}
            }catch (SQLException e){
                System.out.println(e);
            }finally {
                try {
                    MyDriver.closeConnection();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }
    }


