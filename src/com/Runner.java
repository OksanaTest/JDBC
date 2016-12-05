package com;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchMethodException {
        /*
        create menu to select action;
        to view tables, tables structure please select point 1 in the menu
         */
        System.out.println("To select action with DB please choose one of the following " +
                "digit:" + "\n");
        System.out.println("1 Select information from DB;" + "\n" +
                "2 Update\\Insert\\Delete information in the DB;" + "\n");

        Scanner scanner = new Scanner(System.in);
        Integer digit = scanner.nextInt();
        String string = "Enter you SQL query below: ";
        switch (digit) {
            case 1:
                System.out.println(string);
                inputSelectData();
                break;
            case 2:
                System.out.println(string);
                inputData();
                break;
            default:
                System.out.println("You did't select correct case please try again");
                }
        }
    private static void inputData() {
        Scanner scanner = new Scanner(System.in);
        String SQL = scanner.nextLine();
        SQLExecuter.updateAndInsert(SQL);
    }
    private static void inputSelectData() {
        Scanner scanner = new Scanner(System.in);
        String SQL = scanner.nextLine();
        SQLExecuter.select(SQL);

    }
}

