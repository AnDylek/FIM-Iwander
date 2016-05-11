/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iwander.Database;

import java.awt.List;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnDylek
 */
public class Connect {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://db4free.net/iwander";
    static final String USER = "pilot";
    static final String PASS = "letiště";

    public Connect() {
        Connection conn = null;
        Statement stmt = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            /*
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Airport";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String iata = rs.getString("IATA");
                String icao = rs.getString("ICAO");
                String name = rs.getString("Name");
                String airportid = rs.getString("AirportID");

                //Display values
                System.out.print("IATA: " + iata);
                System.out.print(", ICAO: " + icao);
                System.out.print(", Name: " + name);
                System.out.println(", AirportID: " + airportid);
            }*/
            //STEP 6: Clean-up environment

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public String vyhledaniLetu(String odkud) {
        Connection conn = null;
        Statement stmt = null;
        String vysledek = "";
        String kam = odkud;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            stmt = DriverManager.getConnection(DB_URL, USER, PASS).createStatement();
            String sql;
            sql = "Select * from Airport where name = '" + kam + "'";
            System.out.println("SQL: " + sql);

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                String iata = rs.getString("IATA");
                String icao = rs.getString("ICAO");
                String name = rs.getString("Name");
                String airportid = rs.getString("AirportID");

                //Display values
                System.out.print("IATA: " + iata);
                System.out.print(", ICAO: " + icao);
                System.out.print(", Name: " + name);
                System.out.println(", AirportID: " + airportid);
                vysledek += "\n Název letiště je: " + name + " s ID: " + airportid;
            }
            rs.close();
            stmt.close();
            DriverManager.getConnection(DB_URL, USER, PASS).close();
            return vysledek;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList getAirport() {
        ArrayList list = new ArrayList();
            int index = 0;
        try {
            
            Connection conn = null;
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            stmt = DriverManager.getConnection(DB_URL, USER, PASS).createStatement();
            String sql;
            sql = "Select name from Airport";
            System.out.println("SQL: " + sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("Name");         
                list.add(index, name);
                index ++;
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList getCity() {
        ArrayList list = new ArrayList();
            int index = 0;
        try {
            Connection conn = null;
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            stmt = DriverManager.getConnection(DB_URL, USER, PASS).createStatement();
            String sql;
            sql = "Select Name from City";
            System.out.println("SQL: " + sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //Retrieve by column name
                String name = rs.getString("Name");         
                list.add(index, name);
                index ++;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
             return list;
    


}
}
