package com.nmi.uk.dbtest.main;

/**
 * Created by Darren on 25/08/2014.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static String dbURL = "jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine";
    private static String tableName = "restaurants";
    private static Connection conn = null;
    private static Statement stmt = null;

    private static void main(String[] args) {

    }

    private static void getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            conn = DriverManager.getConnection(dbURL);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Get a connection

    }


}
