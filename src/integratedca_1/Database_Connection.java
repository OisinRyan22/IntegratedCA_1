/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integratedca_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ocean
 */
public class Database_Connection {
    private final String DB_URL = "jdbc:mysql://localhost:3306/IntegratedCA_DB1";        //database URL
    private final String user = "root";     //Database username
    private final String password = "Gethelp33!";       //database password
    
    //Method to establish a connection to the database
    public Connection connect() {
        try {
            //Establish a connection using DriveManager
            return DriverManager.getConnection(DB_URL, user, password);
        } catch (SQLException e) {
            //If connection fails, throw a runtime exception with error message and cause
            throw new RuntimeException("Error connecting to database", e);
        }
    }
}
