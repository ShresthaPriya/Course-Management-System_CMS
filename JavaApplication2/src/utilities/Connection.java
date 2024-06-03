/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import utilities.Constants;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Connection {

    public static java.sql.Connection conn;
    public static Statement stm;
    public static PreparedStatement prpStm;

    public static java.sql.Connection getConnection() throws SQLException {
        try {
            Class.forName(Constants.forNameConstant);
            conn = DriverManager.getConnection(Constants.getConnectionNameConstant);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, "Failed to connect to the database.", ex);
            Logger.getLogger(Connection.class.getName()).log(Level.INFO, "Connection URL: " + Constants.getConnectionNameConstant);
            throw ex;
        }
        return conn;
    }
}

