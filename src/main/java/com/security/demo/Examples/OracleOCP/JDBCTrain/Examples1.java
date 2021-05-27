package com.security.demo.Examples.OracleOCP.JDBCTrain;

import javax.sql.DataSource;
import java.sql.*;

public class Examples1 {
    public static void main(String[] args) {
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/animals?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","23892389Sey.");
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM names");
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                System.out.println(rs.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}
