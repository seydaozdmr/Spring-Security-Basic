package com.security.demo.Examples.OracleOCP.JDBCTrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static Connection conn;

    private ConnectionDB(){

    }

    public static Connection getInstance(){
        if(conn==null){
            try {
                conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/animals?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","somepassword");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }
}
