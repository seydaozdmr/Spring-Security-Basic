package com.security.demo.Examples.OracleOCP.JDBCTrain;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Examples1 {
    public static void main(String[] args) {
        Map<Integer,String> idToNameMap=new HashMap<>();

        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/animals?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","23892389Sey.");
            PreparedStatement ps=connection.prepareStatement("SELECT * FROM names");
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                //System.out.println(rs.getString(3));
                int id=rs.getInt("id");
                String name=rs.getString("name");
                idToNameMap.put(id,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println(idToNameMap);



//        try(Connection conn=ConnectionDB.getInstance()){
//            String query="INSERT INTO names VALUES(3,2,'Aslan')";
//            PreparedStatement ps=conn.prepareStatement(query);
//            int result=ps.executeUpdate();
//            System.out.println(result);
//        }catch (SQLException throwables){
//            throwables.printStackTrace();
//        }

        try(Connection conn=ConnectionDB.getInstance()){
            PreparedStatement ps=conn.prepareStatement("SELECT * FROM names");
            boolean isResultSet=ps.execute();
            if(isResultSet){
                try(ResultSet rs=ps.getResultSet()){
                    System.out.println("ran a query");
                }
            }else{
                int result=ps.getUpdateCount();
                System.out.println(result+ " ran an update");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }



    }
}
